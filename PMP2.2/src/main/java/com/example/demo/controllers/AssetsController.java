package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.entities.Assets;
import com.example.demo.repository.AssetRepository;


@Controller
public class AssetsController {
	
	@Autowired
	private AssetRepository assetRepository;
	
	@RequestMapping(value="/assets_manage")
	public String ManageAsset(Model model) {
		
		List<Assets> asset =assetRepository.findAll();
		model.addAttribute("as",asset);
		
		return "assets_manage";
	}
	

}
