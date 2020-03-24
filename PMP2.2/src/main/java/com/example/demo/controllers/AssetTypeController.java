package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.AssetType;

import com.example.demo.repository.AssetTypeRepository;

@Controller
public class AssetTypeController{
	
	@Autowired
	private AssetTypeRepository assettypeRepository;
	
	@RequestMapping(value="/assetstype_manage")
	public String assetstype_manage(Model model) {
		
		List<AssetType> asstype = assettypeRepository.findAll();
		model.addAttribute("assetstype",asstype);
		
		return "assetstype_manage";
	}
	

}
