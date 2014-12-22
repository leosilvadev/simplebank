package br.fatea.simplebank.config;

import java.util.HashMap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAsync
@EnableWebMvc
@ComponentScan(basePackages = "br.fatea.simplebank.*")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		HashMap<String, MediaType> mediaTypes = new HashMap<>();
		mediaTypes.put("xml", MediaType.APPLICATION_XML);
		mediaTypes.put("json", MediaType.APPLICATION_JSON);
		
		configurer.mediaTypes(mediaTypes)
				.defaultContentType(MediaType.APPLICATION_JSON)
				.favorParameter(false)
				.favorPathExtension(true);
		
		super.configureContentNegotiation(configurer);
	}
	
}