package com.sample.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sample.model.Role;
import com.sample.model.User;

public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;

	private List<SimpleGrantedAuthority> auhorities = new LinkedList<>();

	public MyUserDetails(User user) {
		super();
		this.user = user;
		for (Role role : user.getRoles()) {
			auhorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return auhorities;
	}

	@Override
	public String getPassword() {
		return getUser().getPassword();
	}

	@Override
	public String getUsername() {
		return getUser().getEmail();
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

	public User getUser() {
		return user;
	}

}
