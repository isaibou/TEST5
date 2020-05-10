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
	
	@RequestMapping(value ="/addTypIntReq")
	public String addTypIntReq( Model model) {
		 model.addAttribute("typint",new TypeInternalRequest());	 
			return "addTypIntReq";
	}
	
	@RequestMapping(value = "/editTypeInternalRequest",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateTypeInternalRequest(Model model, @Valid TypeInternalRequest typInReq, BindingResult bindingResult){

		typeInternalRequestRepository.save(typInReq);
		
		return "redirect:/typeRequest";
	}
	
	@RequestMapping(value ="/updateTypeInternalRequest")
	public String updateTypeIntReqForm( Model model, Integer id ) {
		
		 TypeInternalRequest	typeInternalRequest = typeInternalRequestRepository.getOne(id);
		 model.addAttribute("typInReq",typeInternalRequest);
		 
			return "updateTypeIntReqForm";
	}

	@RequestMapping(value="/addTypeExternalRequest")
	public String addTypeExternalRequest( TypeExternalRequest external) {
		
		typeExternalRequestRepository.save(external);
		return"redirect:/typeRequest";
	}

	@RequestMapping(value ="/addTypExtReq")
	public String addTypExtReq( Model model) {
		 model.addAttribute("typext",new TypeExternalRequest());	 
			return "addTypExtReq";
	}
	
	@RequestMapping(value = "/editTypeExternalRequest",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateTypeExternalRequest(Model model, @Valid TypeExternalRequest typExReq, BindingResult bindingResult){

		typeExternalRequestRepository.save(typExReq);
		
		return "redirect:/typeRequest";
	}
	
	@RequestMapping(value ="/updateTypeExternalRequest")
	public String updateTypeExtReqForm( Model model, Integer id ) {
		
		 TypeExternalRequest	TypeExternalRequest = typeExternalRequestRepository.getOne(id);
		 model.addAttribute("typExReq",TypeExternalRequest);
		 
			return "updateTypeExtReqForm";
	}
	
}
