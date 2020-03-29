package com.example.demo.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	private String SaveCustomer(@Valid Customer addCust, BindingResult bindingResult) {
		
		addCust.setStatus("Actif");
	
		customerrepository.save(addCust);
		return "redirect:/customer_manage";
		
		
		
	}
	
	@RequestMapping(value ="/updateCustomerform" )
	private String updateCustomerform( Model model, Integer id ) {
	Customer	customer = customerrepository.getOne(id);
		 model.addAttribute("customer",customer);
		 System.out.println(customer.getName());
		
			return "updateCustomerForm";
			
	}
	
	@RequestMapping(value = "/editCustomer",method= RequestMethod.POST)
	public String updateCustomer(Model model, Customer cust){
	cust= 	(Customer) model.getAttribute("customer");
		customerrepository.save(cust);
		
		return "redirect:/customer_manage";
	}


	@RequestMapping(value ="/archiverCustomer" )
	private String archiverCustomer( Model model, Integer id ) {
	
	Customer Cust = customerrepository.getOne(id);
	Cust.setStatus("Archived");
	Cust.setName("Ibrahim");
	customerrepository.save(Cust);
	System.out.println(Cust.getStatus());
		
			return "redirect:/customer_manage";	}

}
 	