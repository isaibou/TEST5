package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReferenceController {
	
	@RequestMapping(value="/projects_reference_manage")
	public String ReferenceManage() {
		return "projects_reference_manage";
	}

}
