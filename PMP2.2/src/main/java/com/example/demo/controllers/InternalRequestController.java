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
import org.springframework.web.bind.annotation.RequestParam;

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
	private InternalRequestRepository internalRequestrepository;

	@Autowired
	private ExternalRequestRepository externalRequestrepository;
	
	@Autowired
	private TypeInternalRequestRepository typeInternalRequestrepository;
	
	@Autowired
	private TypeExternalRequestRepository typeExternalRequestrepository;
	
	@Autowired
	private UserRepository userRepository;

	DateFormat df = new SimpleDateFormat("yyyy-	MM-dd");
	
	@RequestMapping(value="/request")
	public String AllCustomer(Model model, Authentication auth) {
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
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
	public String addInternalRequest(@Valid @ModelAttribute("int") InternalRequest internal,BindingResult bindingResult, Authentication  auth ) {
		
		 if(bindingResult.hasErrors()) {
		 
			return "addReqEmp";
		}
		
		String login = auth.getName();
		Users u =  userRepository.getOne(login);
		internal.setUserEmployee(u);
		internal.setSubmitedDate(new Date());
		internal.setStatus("Waiting");
		
		internalRequestrepository.save(internal);
		return"redirect:/request";
	}
	
	@RequestMapping(value ="/addReqEmp" )
	public String addReqEmp(Model model) {
		model.addAttribute("int", new InternalRequest());
		model.addAttribute("type", typeInternalRequestrepository.findAll());
		return "addReqEmp";
	}
	
	@RequestMapping(value="/answer")
	public String answer( Integer  id ) {
		
		InternalRequest  iR = internalRequestrepository.getOne(id);
		iR.setStatus("Answered");
			
		internalRequestrepository.save(iR);
		return"redirect:/request";
	}
	
	@RequestMapping(value="/confirm")
	public String confirm( Integer  id ) {
		
		InternalRequest  iR = internalRequestrepository.getOne(id);
		iR.setStatus("Confirmed");
		
		
		internalRequestrepository.save(iR);
		return"redirect:/request";
	}
	
	
	@RequestMapping(value ="/updateRequestEmployee" )
	public String updateRequestEmployee(Integer id , Model model) {
		
		InternalRequest  iR = internalRequestrepository.getOne(id);
		model.addAttribute("employeeR", iR);

		return "updateRequestEmployee";
	}
	
	@RequestMapping(value ="/editEmployeeRequest" )
	public String editEmployeeRequest(Integer id , Model model, @RequestParam(name="desc")String description, @RequestParam(name="commentaire")String commentaire) {
		
	InternalRequest iR = internalRequestrepository.getOne(id);
	String previousCom= iR.getCommentaire();
	String NomCompany =  iR.getUserEmployee().getCustomer().getName();
	String com = NomCompany + " :  " + commentaire;
	String newCom = previousCom + "  ------ " + com; 
	iR.setCommentaire(newCom);
	iR.setDescription(description);
	internalRequestrepository.save(iR);
	
		return "redirect:/request";
	}
	
	@RequestMapping(value ="/detailsRequestEmployee" )
	public String detailsRequestEmployee(Integer id , Model model) {
		
		InternalRequest iR = internalRequestrepository.getOne(id);
		model.addAttribute("iR", iR);
		
		return "detailsRequestEmployee";
	}	
}
