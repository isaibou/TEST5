package com.example.demo.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.*;
import com.example.demo.repository.ExternalRequestRepository;
import com.example.demo.repository.TypeExternalRequestRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ExternalRequestController {
	
	@Autowired
	private ExternalRequestRepository externalRequestRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TypeExternalRequestRepository typeExternalRequestRepository;
	
	@RequestMapping(value="/addExternalRequest")
	public String addInternalRequest(@Valid @ModelAttribute("ext") ExternalRequest external,BindingResult bindingResult, Authentication  auth ) {
		
		if(bindingResult.hasErrors()) {
			return "addReqCust";
		}
		
		String login = auth.getName();
		Users u =  userRepository.getOne(login);
		external.setUserCustomer(u);
		external.setSubmitedDate(new Date());
		external.setCommentaire("");

		externalRequestRepository.save(external);
		return"redirect:/request";
	}
	
	@RequestMapping(value ="/addReqCust" )
	public String addReqCust(Model model) {
		model.addAttribute("ext", new ExternalRequest());
		model.addAttribute("type", typeExternalRequestRepository.findAll());
		return "addReqCust";
	}
	
	@RequestMapping(value="/answerC")
	public String answserC( Integer  id ) {
		
		ExternalRequest  eR = externalRequestRepository.getOne(id);
		eR.setStatus(true);
		
		externalRequestRepository.delete(eR);
		
		return"redirect:/request";
	}
	
	@RequestMapping(value ="/updateRequestCustomer" )
	public String updateRequestCustomer(Integer id , Model model) {
		
		ExternalRequest  eR = externalRequestRepository.getOne(id);
		model.addAttribute("customerR", eR);

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