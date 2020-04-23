package com.example.demo.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.*;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.customerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerrepository; 

	@Autowired
	private customerService customerService;
	
	@RequestMapping(value="/customer_manage")
	public String AllCustomer(Model model, Customer customer) {
		
		List<Customer> custs = customerrepository.findAll();
		model.addAttribute("cust", custs);
		model.addAttribute("customer", new Customer());
		model.addAttribute("totalCustomer", custs.size());
		
		return "customer_manage";
	}
	@RequestMapping(value="/SaveCustomer" , method= RequestMethod.POST)
	private String SaveCustomer(@Valid Customer addCust, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView MV = new ModelAndView();
		if (bindingResult.hasErrors()) {
		    MV.addObject("successMessage", "plz correct the errors in form !");
			modelMap.addAttribute("bindingResult", bindingResult);
        }
		else if (customerService.isCustomerNameAlreadyPresent(addCust)) {
			MV.addObject("successMessage", "customer already exists !");
		}
		addCust.setStatus("Actif");
		customerrepository.save(addCust);
		
		return "redirect:/customer_manage";	
	}
	
	@RequestMapping(value ="updateCustomerform" )
	private String updateCustomerform( Model model, Integer id ) {
		Customer customer = customerrepository.getOne(id);
		model.addAttribute("customer",customer);
		System.out.println(customer.getName());
		return "updateCustomerForm";			
	}
	
    @RequestMapping(value = "/editCustomer",method= RequestMethod.POST)
	private String updateCustomer(@Valid Customer addCust, BindingResult bindingResult) {
			addCust.setStatus("Actif");
			customerrepository.save(addCust);
		return "redirect:/customer_manage";
	}

	@RequestMapping(value ="/detailCustomer")
	public String detailCustomer( Model model, Integer id ) {
		Customer customer = customerrepository.getOne(id);
		 model.addAttribute("customer",customer);
		 System.out.println(customer.getName());	
			return "detailCust";
	}
	
	@RequestMapping(value ="/archiverCustomer" )
	private String archiverCustomer( Model model, Integer id ) {
		Customer Cust = customerrepository.getOne(id);
	    Cust.setStatus("Archived");
        customerrepository.save(Cust);
        
	    return "redirect:/customer_manage";			
	}

}
 	