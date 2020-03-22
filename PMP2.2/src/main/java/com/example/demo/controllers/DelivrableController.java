package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DelivrableController {
	
	@RequestMapping(value="/project_delivrable_manage")
	public String DelivrableManage() {
		
		return "project_delivrable_manage";
	}
	

}
