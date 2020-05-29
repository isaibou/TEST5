package com.example.demo.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.*;
import com.example.demo.repository.ExternalRequestRepository;
import com.example.demo.repository.InternalRequestRepository;
import com.example.demo.repository.TypeExternalRequestRepository;
import com.example.demo.repository.TypeInternalRequestRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ExternalRequestController {
	
	@Autowired
	private ExternalRequestRepository externalRequestRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TypeExternalRequestRepository typeExternalRequestRepository;
	
	@Autowired
	private InternalRequestRepository internalRequestrepository;
	
	@Autowired
	private TypeInternalRequestRepository typeInternalRequestrepository;


	DateFormat df = new SimpleDateFormat("yyyy-	MM-dd");
	
	@RequestMapping(value ="/request", method = RequestMethod.GET)
	public String AllCustomer(Model model, Customer customer, Authentication auth) {
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
		List<InternalRequest> intAll = internalRequestrepository.findAll();
		List<ExternalRequest> extAll = externalRequestRepository.findAll();
		//List<ExternalRequest> extWait = externalRequestRepository.findByStatus(false);
		List<InternalRequest> intWait = internalRequestrepository.findByStatus("Waiting");
		List<InternalRequest> intConf = internalRequestrepository.findByStatus("Confirmed");

		
		
		model.addAttribute("listInt", intAll);
		model.addAttribute("listExt", extAll);
		model.addAttribute("internal", new InternalRequest());
		model.addAttribute("external", new ExternalRequest());
		model.addAttribute("intAll", intAll.size());
		model.addAttribute("extAll", extAll.size());
		model.addAttribute("typeInternal", typeInternalRequestrepository.findAll());
		model.addAttribute("typeExternal", typeExternalRequestRepository.findAll());
		model.addAttribute("intWait", intWait.size());
		model.addAttribute("intConf", intConf);
		//model.addAttribute("extWait", extWait.size() );
		
		
		return "request";
	}
	
	@RequestMapping(value="/addExternalRequest")
	public String addInternalRequest(@Valid @ModelAttribute("ext") ExternalRequest external,BindingResult bindingResult,Model model,  Authentication  auth ) {
		
		 if(bindingResult.hasErrors()) {
			 model.addAttribute("type", typeExternalRequestRepository.findAll());
		 
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
		
		externalRequestRepository.save(eR);
		
		return"redirect:/request";
	}
	
	@RequestMapping(value ="/updateRequestCustomer" )
	public String updateRequestCustomer(Integer id , Model model) {
		
		ExternalRequest  eR = externalRequestRepository.getOne(id);
		model.addAttribute("customerR", eR);

		return "updateRequestCustomer";
	}
	
	@RequestMapping(value ="/editCustomerRequest" )
	public String editCustomerRequest(Integer id , Model model, @RequestParam(name="com")String commentaire) {
		
	ExternalRequest eR = externalRequestRepository.getOne(id);
		/*
		 * String previousCom= eR.getCommentaire(); String NomCompany =
		 * eR.getUserCustomer().getCustomer().getName(); String com = NomCompany +
		 * " :  " + commentaire; String newCom = previousCom + "  -----------   " + com;
		 */ 
	eR.setCommentaire(commentaire);
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