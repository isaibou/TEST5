package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.*;
import com.example.demo.repository.CustomerRepository;



@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerrepository; 
	
	@RequestMapping(value="/customer_manage")
	public String AllCustomer(Model model, Customer customer) {
		
		List<Customer> custs = customerrepository.findAll();
		model.addAttribute("cust", custs);
		model.addAttribute("customer", new Customer());
		
		return "customer_manage";
	}
	
	
	@RequestMapping(value="/SaveCustomer" , method= RequestMethod.POST)
	private String SaveCustomer(Customer addCust) {
		customerrepository.save(addCust);
		return "redirect:/customer_manage";
		
	}
	
	@RequestMapping(value ="/updateCustomerform" )
	private String updateCustomerform( Model model, Integer id ) {
	Customer	customer = customerrepository.getOne(id);
		 model.addAttribute("customerUp",customer);
		 System.out.println(customer.getName());
		
			return "updateCustomerForm";
			
	}
	
	@RequestMapping(value = "/updateCustomer",method= RequestMethod.POST)
	public String updateCustomer(Model model, Customer cust){
		customerrepository.save(cust);
		
		return "redirect:/customer_manage";
	}


	@RequestMapping(value ="/deleteCustomer" )
	private String deleteCustomer( Model model, Integer id ) {
	
		customerrepository.deleteById(id);
		
			return "redirect:/customer_manage";	}

}
 	