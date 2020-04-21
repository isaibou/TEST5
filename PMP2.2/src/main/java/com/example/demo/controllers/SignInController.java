package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Users;
import com.example.demo.repository.UserRepository;



@Controller
public class SignInController {
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/LoginVrai")
	public String Login() {
		return "LoginVrai";
	}

	@RequestMapping(value="/403")
	public String accesDenied() {
		return "403";
	}

	@RequestMapping(value="/index")
	public String index( Model model, Authentication authentication) {
		
		/*
		 * String login= authentication.getName(); Users user=
		 * userRepository.getOne(login); model.addAttribute("user", user);
		 */
		
		return "index";
	}
	
	

}
