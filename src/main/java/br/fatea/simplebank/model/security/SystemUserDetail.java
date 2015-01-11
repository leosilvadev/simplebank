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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = systemUser.getRoles().stream().map(
			(role) -> new SimpleGrantedAuthority(role.getName())
		).collect(Collectors.toList());
		return authorities;
	}

	@Override
	public String getPassword() {
		return systemUser.getPassword();
	}

	@Override
	public String getUsername() {
		return systemUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}