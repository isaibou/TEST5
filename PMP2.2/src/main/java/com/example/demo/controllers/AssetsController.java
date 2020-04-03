package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.*;
import com.example.demo.repository.AssetRepository;


@Controller
public class AssetsController {
	
	@Autowired
	private AssetRepository assetRepository;
	
	@RequestMapping(value="/assets_manage")
	public String allAsset(Model model, Assets asset) {
		
		List<Assets> assets = assetRepository.findAll();
		model.addAttribute("asset", assets);
		model.addAttribute("assets", new Assets());
		
		return "assets_manage";
	}
	

}
