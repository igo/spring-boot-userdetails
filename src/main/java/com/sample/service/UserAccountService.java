package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.User;
import com.sample.model.UserRepository;

@Service
public class UserAccountService {

	@Autowired
	protected UserRepository userRepository;

	public User getUserByEmail(String email) {
		System.err.println("Repository search for user " + email);
		User user = userRepository.findByEmail(email);
		System.err.println("Repository found user " + user);
		return user;
	}

}