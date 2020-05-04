package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Customer;
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
	

	@RequestMapping(value="/addTypeExpenses")
	public String addTypeExpenses(TypeExpenses type) {

		typeExpensesRepository.save(type);
		return"redirect:/typeExpenses";
	}
	
	
	
	@RequestMapping(value="/deleteTypeExpenses")
	public String deleteTypeExpenses(Model model, Integer id) {
			TypeExpenses type = typeExpensesRepository.getOne(id);
			typeExpensesRepository.delete(type);
		
			return"redirect:/typeExpenses";
	}

	

}
