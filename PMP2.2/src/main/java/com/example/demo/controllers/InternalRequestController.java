package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Frimware;
import com.example.demo.entities.InternalRequest;
import com.example.demo.repository.FrimwareRepository;
import com.example.demo.repository.InternalRequestRepository;

@Controller
public class InternalRequestController {
	
	@Autowired
	private InternalRequestRepository internalrequestRepository;
	
	@RequestMapping(value="/internal_request_manage")
	public String InternalRequestManage(Model model) {
		
		List<InternalRequest> internalRequest = internalrequestRepository.findAll();
		model.addAttribute("interreq",internalRequest );
		
		return"internal_request_manage";
	}

}
