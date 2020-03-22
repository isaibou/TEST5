package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssetsController {
	
	@RequestMapping(value="/assets_manage")
	public String ManageAsset() {
		return "assets_manage";
	}
	

}
