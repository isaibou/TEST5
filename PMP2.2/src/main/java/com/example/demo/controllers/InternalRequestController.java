package com.example.demo.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class InternalRequestController {
	
	public String InternalRequestManage() {
		return"internal_request_manage";
	}

}
