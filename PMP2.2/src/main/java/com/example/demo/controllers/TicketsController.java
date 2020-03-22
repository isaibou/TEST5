package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketsController {
	
	@RequestMapping(value="/tickets_manage")
	public String TicketsManage() {
		
		return "tickets_manage";
	}

}
