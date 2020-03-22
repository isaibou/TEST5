package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContractController {

	@RequestMapping(value="/contract_manage")
	public String Contract() {
		return "contract_manage"; 
	}
}
