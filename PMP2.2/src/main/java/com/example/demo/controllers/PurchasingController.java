package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Assets;
import com.example.demo.entities.Purchasing;

import com.example.demo.repository.PurchisingRepository;

@Controller
public class PurchasingController {
	@Autowired
	private PurchisingRepository purchisingRepository;
	
	@RequestMapping(value="/purchasing_customer_manage")
	public String purchasing_customer_manage(Model model) {
		
	    List<Purchasing> purchasing = purchisingRepository.findAll();
		model.addAttribute("purchasing",purchasing);
		
		return "purchasing_customer_manage";
	
	}

}
