package com.cp6.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailImpl implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users users;

	public UserDetailImpl(Users users) {
		super();
		this.users = users;
	}	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<Roles> userRoles = users.getRoles();
		System.out.println("==========> UsersDetailImpl Set<Roles> userRoles.size():: " + userRoles.size() );

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Roles userRole : userRoles) {
			System.out.println("==========> UsersDetailImpl,userRole:: " + userRole);
			authorities.add(new SimpleGrantedAuthority(userRole.getName()));
		}

		return authorities;
//		return Collections.singleton(new SimpleGrantedAuthority("NTUC"));
	}

	@Override
	public String getPassword() {
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		return  users.getUsername();
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
