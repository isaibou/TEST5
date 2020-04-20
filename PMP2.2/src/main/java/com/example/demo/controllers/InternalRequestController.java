package com.example.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Customer;
import com.example.demo.entities.ExternalRequest;
import com.example.demo.entities.Frimware;
import com.example.demo.entities.InternalRequest;
import com.example.demo.entities.TypeInternalRequest;
import com.example.demo.entities.Users;
import com.example.demo.repository.ExternalRequestRepository;
import com.example.demo.repository.FrimwareRepository;
import com.example.demo.repository.InternalRequestRepository;
import com.example.demo.repository.TypeExternalRequestRepository;
import com.example.demo.repository.TypeInternalRequestRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class InternalRequestController {
	
	@Autowired
	 InternalRequestRepository internalRequestrepository;

	@Autowired
	 ExternalRequestRepository externalRequestrepository;
	
	@Autowired
	TypeInternalRequestRepository typeInternalRequestrepository;
	
	@Autowired
	TypeExternalRequestRepository typeExternalRequestrepository;
	
	@Autowired
	UserRepository userRepository;


	
	@RequestMapping(value="/request")
	public String AllCustomer(Model model, Customer customer) {
		
		List<InternalRequest> intAll = internalRequestrepository.findAll();
		List<ExternalRequest> extAll = externalRequestrepository.findAll();
		
	
		

		model.addAttribute("listInt", intAll);
		model.addAttribute("listExt", extAll);
		model.addAttribute("internal", new InternalRequest());
		model.addAttribute("external", new ExternalRequest());
		model.addAttribute("intAll", intAll.size());
		model.addAttribute("extAll", extAll.size());
		model.addAttribute("typeInternal", typeInternalRequestrepository.findAll());
		model.addAttribute("typeExternal", typeExternalRequestrepository.findAll());

		
		return "request";
	}

	@RequestMapping(value="/addInternalRequest")
	public String addInternalRequest( InternalRequest internal, Authentication  auth ) {
		
		String login = auth.getName();
		Users u =  userRepository.getOne(login);
		internal.setUserEmployee(u);
		internal.setSubmitedDate(new Date());
		
	
		internalRequestrepository.save(internal);
		return"redirect:/request";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
