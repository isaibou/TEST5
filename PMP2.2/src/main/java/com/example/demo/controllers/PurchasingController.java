package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurchasingController {
	@RequestMapping(value = "/purchasing_customer_manage")
	public String Purchasing() {
		return"purchasing_customer_manage";
	}

}
