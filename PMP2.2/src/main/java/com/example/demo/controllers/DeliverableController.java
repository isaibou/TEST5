package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.*;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DeliverableRepository;

@Controller
public class DeliverableController {
	
	@Autowired
	private DeliverableRepository deliverablerepository; 
	
	@RequestMapping(value="/deliverable_manage")
	public String DelivrableManage(Model model) {
		
		List<Deliverable> delive = deliverablerepository.findAll();
		model.addAttribute("deliverable", delive);
		return "deliverable_manage";
	}
	

}
