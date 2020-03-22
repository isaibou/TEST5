package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExternalRequestController {
	
	@RequestMapping(value="/external_request_manage")
	public String ExternalRequest() {
		
		return "external_request_manage";
	}

}
