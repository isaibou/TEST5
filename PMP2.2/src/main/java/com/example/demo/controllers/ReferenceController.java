package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReferenceController {
	
	@RequestMapping(value="/reference_manage")
	public String ReferenceManage() {
		return "reference_manage";
	}

}
