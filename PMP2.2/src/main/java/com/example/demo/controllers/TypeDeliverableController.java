package com.example.demo.controllers;

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

import com.example.demo.entities.Customer;
import com.example.demo.entities.Purchasing;
import com.example.demo.entities.TypeDeliverable;
import com.example.demo.entities.TypeExpenses;
import com.example.demo.entities.TypeExternalRequest;
import com.example.demo.entities.TypeInternalRequest;
import com.example.demo.entities.Users;
import com.example.demo.repository.TypeDeliverableRepository;
import com.example.demo.repository.TypeExpensesRepository;
import com.example.demo.repository.TypeExternalRequestRepository;
import com.example.demo.repository.TypeInternalRequestRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class TypeDeliverableController {
	
	@Autowired
	TypeDeliverableRepository typeDeliverablerepository;
		
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/typeDeliverable")
	public String typeDeliverable(Model model, Authentication auth) {
		
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
	List<TypeDeliverable> allType = typeDeliverablerepository.findAll();
	model.addAttribute("totalTypeDelivProject", allType.size());
	model.addAttribute("alltype", allType);
	model.addAttribute("type", new TypeDeliverable());
	
		return"typeDeliverable";
	}
	
	@RequestMapping(value="/addTypeDeliverable")
	public String addTypeDeliverable(Model model, @Valid @ModelAttribute("typDeliv") TypeDeliverable type,BindingResult bindingResult) {
		
           if(typeDeliverablerepository.checkTitleExist(type.getNameTypeDeliverable())) {
			
			model.addAttribute("unique", "must be unique");
			return "addTypDeliv";
		}

		if(bindingResult.hasErrors()) {
			return "addTypDeliv";
		}
		
		typeDeliverablerepository.save(type);
		return"redirect:/typeDeliverable";
	}
	
	@RequestMapping(value ="/addTypDeliv")
	public String addTypDeliv( Model model) {
		 model.addAttribute("typDeliv",new TypeDeliverable());
		 
			return "addTypDeliv";
	}
	
	@RequestMapping(value = "/editTypeDeliverable",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateTypeDeliverable(Model model, @Valid TypeDeliverable typDeli, BindingResult bindingResult){
		
if(typeDeliverablerepository.checkTitleExist(typDeli.getNameTypeDeliverable())) {
	
	        TypeDeliverable	typeDeliverable = typeDeliverablerepository.getOne(typDeli.getTypeDeliverable_ID());
	        model.addAttribute("typDelv",typeDeliverable);
	 
			model.addAttribute("unique", "must be unique");
			return "updateTypeDelivForm";
		}
		
		typeDeliverablerepository.save(typDeli);
		
		return "redirect:/typeDeliverable";
	}
	
	@RequestMapping(value ="/updateTypeDeliverable")
	public String updateTypeDelivForm( Model model, Integer id ) {
		
		 TypeDeliverable	typeDeliverable = typeDeliverablerepository.getOne(id);
		 model.addAttribute("typDelv",typeDeliverable);
		 
			return "updateTypeDelivForm";
	}
	
	/*@RequestMapping(value="/deleteTypeDeliverable")
	public String deleteTypeDelivrable(Model model, Integer id) {
			TypeDeliverable type = typeDeliverablerepository.getOne(id);
			typeDeliverablerepository.delete(type);
		
			return"redirect:/typeDeliverable";
	}*/

	

}