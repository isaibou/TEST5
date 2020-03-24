package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.*;
import com.example.demo.repository.CustomerRepository;



@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerrepository; 
	
	@RequestMapping(value="/customer_manage")
	public String Customer(Model model) {
		
		List<Customer> custs = customerrepository.findAll();
		model.addAttribute("cust", custs);
		

		return "customer_manage";
	}
}
