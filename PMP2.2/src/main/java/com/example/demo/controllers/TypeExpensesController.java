package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Customer;
import com.example.demo.entities.TypeDeliverable;
import com.example.demo.entities.TypeExpenses;
import com.example.demo.entities.TypeExternalRequest;
import com.example.demo.entities.TypeInternalRequest;
import com.example.demo.entities.Users;
import com.example.demo.repository.TypeExpensesRepository;
import com.example.demo.repository.TypeExternalRequestRepository;
import com.example.demo.repository.TypeInternalRequestRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class TypeExpensesController {
	
	@Autowired
	TypeExpensesRepository typeExpensesRepository;
	
	@Autowired
	private UserRepository userRepository;
		
	@RequestMapping(value="/typeExpenses")
	public String InternalRequestManage(Model model, Authentication auth) {
		
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
	List<TypeExpenses> allTypeExpenses= typeExpensesRepository.findAll();
	
	model.addAttribute("tE", allTypeExpenses);
	model.addAttribute("type", new TypeExpenses());
	
		return"typeExpenses";
	}
	

	@RequestMapping(value="/SaveypeExpenses")
	public String addTypeExpenses(@Valid TypeExpenses type, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			return "addTypExp";
		}
		
		typeExpensesRepository.save(type);
		return"redirect:/typeExpenses";
	}
	
	@RequestMapping(value ="/addTypExp")
	public String addTypExp( Model model) {
		
		 model.addAttribute("typeExpenses",new TypeExpenses());
		 
			return "addTypExp";
	}
	
	@RequestMapping(value = "/editTypeExpenses",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateTypeExpenses(Model model, @Valid TypeExpenses typeEx, BindingResult bindingResult){

		typeExpensesRepository.save(typeEx);
		
		return "redirect:/typeExpenses";
	}
	
	@RequestMapping(value ="/updateTypeExpenses")
	public String updateTypeExpForm( Model model, Integer id ) {
		
		 TypeExpenses	typeExpenses = typeExpensesRepository.getOne(id);
		 model.addAttribute("typeEx",typeExpenses);
		 
			return "updateTypeExpForm";
	}

}
