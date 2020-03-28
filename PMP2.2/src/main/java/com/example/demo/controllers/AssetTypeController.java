package com.example.demo.controllers;

import java.util.Date;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.AssetType;

import com.example.demo.repository.AssetTypeRepository;

import javassist.expr.NewArray;

import com.example.demo.repository.AssetTypeRepository;


@Controller

public class AssetTypeController
{

	@Autowired
	private AssetTypeRepository assetTypeRepository;

	
	@RequestMapping(value="/assetstype_manage")
	public String Assetstype_Manage(Model model, AssetType assetType) {
		
	List<AssetType>	ListassetType = assetTypeRepository.findAll();
	model.addAttribute("ListassetType" , ListassetType);
	model.addAttribute("assetType", new AssetType());
	//ListassetType.forEach(c->System.out.println(c.getName()));
	
	return "assetstype_manage";
	

	}
		
	
	

}
