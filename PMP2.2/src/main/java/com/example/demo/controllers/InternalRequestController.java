package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InternalRequestController {
	
	@RequestMapping(value="/internal_request_manage")
	public String InternalRequestManage() {
		return"internal_request_manage";
	}

}
