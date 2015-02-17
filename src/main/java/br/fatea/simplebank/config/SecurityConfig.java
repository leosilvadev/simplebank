package br.fatea.simplebank.config;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.DelegatingAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import br.fatea.simplebank.model.domains.SystemUser;
import br.fatea.simplebank.model.repositories.SystemUserRepository;
import br.fatea.simplebank.model.security.SystemUserDetail;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SystemUserRepository systemUserRepository;

	@Bean
	public DelegatingAuthenticationEntryPoint noAuthorizedEntryPoint(){
		LinkedHashMap<RequestMatcher, AuthenticationEntryPoint> entryPoints = new LinkedHashMap<>();
		
		AuthenticationEntryPoint webEntryPoint = (request, response, exception) -> 
			response.sendRedirect(request.getContextPath()+"/app/login");
		
			AuthenticationEntryPoint wsEntryPoint = (request, response, exception) -> 
			response.sendError(401, "No permission!");
		
		entryPoints.put(new AntPathRequestMatcher("/app/**"), webEntryPoint);
		entryPoints.put(new AntPathRequestMatcher("/api/**"), wsEntryPoint);
		entryPoints.put(new AntPathRequestMatcher("/ws/**"), wsEntryPoint);
		
		DelegatingAuthenticationEntryPoint noAuthorizedEntryPoint = new DelegatingAuthenticationEntryPoint(entryPoints);
		noAuthorizedEntryPoint.setDefaultEntryPoint(wsEntryPoint);
		return noAuthorizedEntryPoint;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/api/**").hasRole("API_ACCESS")
			.antMatchers("/ws/**").hasRole("WS_ACCESS")
		.and().httpBasic().authenticationEntryPoint(noAuthorizedEntryPoint())
		.and().csrf().disable()
		.authorizeRequests()
			.antMatchers("/app/login", "/app/authenticate").permitAll()
			.antMatchers("/app/**").hasRole("WEB_ADMIN_ACCESS")
		.and().formLogin()
			.loginPage("/app/login")
			.loginProcessingUrl("/app/authenticate")
			.defaultSuccessUrl("/app/users")
			.failureUrl("/app/login?failure=true")
		.and().logout().logoutUrl("/app/logout");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService((username) -> {
				SystemUser systemUser = systemUserRepository
						.findOneByUsername(username);
				if (systemUser == null)
					throw new UsernameNotFoundException(username);
				return new SystemUserDetail(systemUser);
			}
		).passwordEncoder(encoder());
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}