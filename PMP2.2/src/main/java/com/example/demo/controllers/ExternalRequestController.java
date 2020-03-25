package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.*;
import com.example.demo.repository.ExternalRequestRepository;

@Controller
public class ExternalRequestController {
	
	@Autowired
	private ExternalRequestRepository externalRequestRepository;
	
	@RequestMapping(value="/external_request_manage")
	public String ExternalRequest(Model model) {
		
		List<ExternalRequest> extreq = externalRequestRepository.findAll();
		model.addAttribute("externelreq", extreq );
		
		return "external_request_manage";
	}

	
	}


