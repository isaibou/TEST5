package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Assets;
import com.example.demo.entities.Vendor;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.VendorRepository;

@Controller
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@RequestMapping(value="/vendor")
	public String vendor(Model model) {
		
		List<Vendor> vendor = vendorRepository.findAll();
		model.addAttribute("ven",vendor);
		
		return "vendor";
	}

}
