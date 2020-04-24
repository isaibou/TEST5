package com.example.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.*;
import com.example.demo.repository.ExternalRequestRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ExternalRequestController {
	
	@Autowired
	private ExternalRequestRepository externalRequestRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/addExternalRequest")
	public String addInternalRequest( ExternalRequest external, Authentication  auth ) {
		
		String login = auth.getName();
		Users u =  userRepository.getOne(login);
		external.setUserCustomer(u);
		external.setSubmitedDate(new Date());
		external.setCommentaire("");
		
	
		externalRequestRepository.save(external);
		return"redirect:/request";
	}

	
	
	@RequestMapping(value="/answerC")
	public String answserC( Integer  id ) {
		
		ExternalRequest  eR = externalRequestRepository.getOne(id);
		eR.setStatus(true);
		
		externalRequestRepository.delete(eR);
		
	
		//externalRequestRepository.save(eR);
		return"redirect:/request";
	}
	
	@RequestMapping(value ="/updateRequestCustomer" )
	public String updateRequestCustomer(Integer id , Model model) {
		
		ExternalRequest  eR = externalRequestRepository.getOne(id);
		model.addAttribute("customerR", eR);
		//model.addAttribute("customer", u.getCustomer());
		//model.addAttribute("allRoles", u.getRoles());	
		
	
		return "updateRequestCustomer";
	}
	
	@RequestMapping(value ="/editCustomerRequest" )
	public String editCustomerRequest(Integer id , Model model, @RequestParam(name="commentaire")String commentaire) {
		
	ExternalRequest eR = externalRequestRepository.getOne(id);
	String previousCom= eR.getCommentaire();
	String NomCompany =  eR.getUserCustomer().getCustomer().getName();
	String com = NomCompany + " :  " + commentaire;
	String newCom = previousCom + "  -----------------------------------------------        " + com; 
	eR.setCommentaire(newCom);
	externalRequestRepository.save(eR);
		
	
		return "redirect:/request";
	}
	
	@RequestMapping(value ="/detailsRequestCustomer" )
	public String detailsCustomerRequest(Integer id , Model model) {
		
		ExternalRequest eR = externalRequestRepository.getOne(id);
		model.addAttribute("eR", eR);
		
		
	
		return "detailsRequestCustomer";
	}
	
	
	
	
	
	}


