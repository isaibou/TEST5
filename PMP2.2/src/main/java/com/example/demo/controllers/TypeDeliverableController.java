package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Customer;
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
	
	model.addAttribute("alltype", allType);
	model.addAttribute("type", new TypeDeliverable());


	
		return"typeDeliverable";
	}
	

	@RequestMapping(value="/addTypeDeliverable")
	public String addTypeDeliverable(TypeDeliverable type) {

		typeDeliverablerepository.save(type);
		return"redirect:/typeDeliverable";
	}
	
	
	
	@RequestMapping(value="/deleteTypeDeliverable")
	public String deleteTypeDelivrable(Model model, Integer id) {
			TypeDeliverable type = typeDeliverablerepository.getOne(id);
			typeDeliverablerepository.delete(type);
		
			return"redirect:/typeDeliverable";
	}

	

}
