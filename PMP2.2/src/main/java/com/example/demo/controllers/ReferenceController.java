package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.entities.Reference;
import com.example.demo.repository.ReferenceRepository;



@Controller
public class ReferenceController {
	
	@Autowired
	private ReferenceRepository referencerepository;
	
	@RequestMapping(value="/reference_manage")
	public String ReferenceManage(Model model) {
		 
		List<Reference> reference = referencerepository.findAll();
		model.addAttribute("refer",reference);
		
		return "reference_manage";
	}

}
