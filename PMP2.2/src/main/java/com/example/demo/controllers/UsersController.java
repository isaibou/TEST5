package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.entities.UserCustomer;

import com.example.demo.repository.UserCustomerRepository;

@Controller
public class UsersController {
	
	@Autowired
	private UserCustomerRepository userCustomerRepository;
	
	@RequestMapping(value="/users")
	public String Users (Model model) {
		{
			
			List<UserCustomer> userscustomer = userCustomerRepository.findAll();
			model.addAttribute("usercustomer", userscustomer);
			

			return "users";
		
	}

	}
}
