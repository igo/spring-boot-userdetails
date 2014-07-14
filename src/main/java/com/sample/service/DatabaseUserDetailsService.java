package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sample.model.User;

public class DatabaseUserDetailsService implements UserDetailsService {

	@Autowired(required = true)
	private UserAccountService userAccountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println("Loading user " + username + "; userAccountService = " + userAccountService);
		User user = userAccountService.getUserByEmail(username);
		System.err.println("Found user " + username);
		return new MyUserDetails(user);
	}

}
