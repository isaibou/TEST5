package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Customer;
import com.example.demo.entities.TypeExternalRequest;
import com.example.demo.entities.TypeInternalRequest;
import com.example.demo.entities.Users;
import com.example.demo.repository.TypeExternalRequestRepository;
import com.example.demo.repository.TypeInternalRequestRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class TypeRequestController {
	
	@Autowired
	TypeInternalRequestRepository typeInternalRequestRepository;
	
	@Autowired
	TypeExternalRequestRepository typeExternalRequestRepository;
	@Autowired
	private UserRepository userRepository;
	

	@RequestMapping(value="/typeRequest")
	public String InternalRequestManage(Model model, Authentication auth) {
		
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
	model.addAttribute("internal", new TypeInternalRequest());
	model.addAttribute("external", new TypeExternalRequest());
	
	List<TypeInternalRequest> tir = typeInternalRequestRepository.findAll();
	List<TypeExternalRequest> ter = typeExternalRequestRepository.findAll();
	
	model.addAttribute("tir", tir);
	model.addAttribute("ter", ter);


	
		return"typeRequest";
	}
	

	@RequestMapping(value="/addTypeInternalRequest")
	public String addTypeInternalRequest( TypeInternalRequest internal) {
		
		typeInternalRequestRepository.save(internal);
		return"redirect:/typeRequest";
	}
	
	
	
	@RequestMapping(value="/deleteTypeInternalRequest")
	public String deleteTypeInternalRequest(Model model, Integer id) {
	TypeInternalRequest tir = typeInternalRequestRepository.getOne(id);	 
		typeInternalRequestRepository.delete(tir);
		
	return"redirect:/typeRequest";
	}

	

	@RequestMapping(value="/addTypeExternalRequest")
	public String addTypeExternalRequest( TypeExternalRequest external) {
		
		typeExternalRequestRepository.save(external);
		return"redirect:/typeRequest";
	}
	
	
	
	@RequestMapping(value="/deleteTypeExternalRequest")
	public String deleteTypeExternalRequest(Model model, Integer id) {
		TypeExternalRequest tir = typeExternalRequestRepository.getOne(id);	 
		typeExternalRequestRepository.delete(tir);
		

		
	return"redirect:/typeRequest";
	}
}
