package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.TypeUserCustomer;
import com.example.demo.repository.FrimwareRepository;
import com.example.demo.repository.TypeUserCustomerRepository;

@Controller
public class TypeUsersController {
	
	@Autowired
	private TypeUserCustomerRepository typeUserCustomerRepository;
	
	@RequestMapping(value="/TypeUsers")
	public String TypeUsers (Model model) {
		{
			
			List<TypeUserCustomer> typeuserscustomer = typeUserCustomerRepository.findAll();
			model.addAttribute("Typeusercustomer", typeuserscustomer);
			

			return "TypeUsers";
		
	}

	}
}
