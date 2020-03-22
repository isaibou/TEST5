package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssetTypeController
{
	@RequestMapping(value="/assetstype_manage")
	public String Assetstype_Manage() {
		return "assetstype_manage";
	}

}
