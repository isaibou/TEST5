package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {
	
	@RequestMapping(value="/Login")
	public String Login() {
		return "Login";
	}

}
