package br.fatea.simplebank.model.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.fatea.simplebank.model.domains.SystemUser;

public class SystemUserDetail implements UserDetails {
	
	private static final long serialVersionUID = -5028285189159361408L;
	private SystemUser systemUser;

	public SystemUserDetail(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = systemUser.getRoles()
				.stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		return authorities;
	}

	public String getPassword() {
		return systemUser.getPassword();
	}

	public String getUsername() {
		return systemUser.getUsername();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
	
}
