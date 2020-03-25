package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.DataCenterRepository;

@Controller
public class DataCenterController {
	
	@Autowired
	private DataCenterRepository dataCenterRepository;
	
	@RequestMapping(value="/r_manage")
	public String index() {
		
		System.out.println("hahahaha");
		return "customer_manage";
	}
	

}
