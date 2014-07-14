package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.service.UserAccountService;

@Controller
public class UserController {

	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", userAccountService.getUserByEmail("user"));
		return "users";
	}
	
}
