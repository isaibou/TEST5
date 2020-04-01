package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {
	
	@RequestMapping(value="/LoginVrai")
	public String Login() {
		return "LoginVrai";
	}

	@RequestMapping(value="/403")
	public String accesDenied() {
		return "403";
	}

	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}

	
	

}
