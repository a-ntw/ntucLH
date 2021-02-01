package com.cp5.daoauthenticate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailImpl implements UserDetails {
	
	private Users users;
	

	public UserDetailImpl(Users users) {
		super();
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<UserRole> userRoles = users.getUserRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (UserRole userRole : userRoles) {
			authorities.add(new SimpleGrantedAuthority(userRole.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
			return users.getPassword();
	}

	@Override
	public String getUsername() {
		return users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
