package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.*;

import com.example.demo.repository.ContratRepository;



@Controller
public class ContractController {

	@Autowired
	private ContratRepository contratrepository; 
	
	@RequestMapping(value="/contract_manage")
	public String ContractManage(Model model) {
		
		List<Contrat> contrat = contratrepository.findAll();
		model.addAttribute("contrat", contrat);
		

		return "contract_manage";
	}
}
