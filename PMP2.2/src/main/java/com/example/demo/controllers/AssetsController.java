package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.AssetType;
import com.example.demo.entities.Assets;
import com.example.demo.repository.AssetRepository;


@Controller
public class AssetsController {
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Secured(value = "ROLE_MANAGER")
	@RequestMapping(value="/assets_manage")
	public String allAsset(Model model, Assets asset) {
		
		List<Assets> assets = assetRepository.findAll();
		model.addAttribute("asset", assets);
		model.addAttribute("assets", new AssetType());
		
		return "assets_manage";
	}
	

}
