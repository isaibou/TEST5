package com.example.demo.controllers;

<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> branch 'master' of https://github.com/isaibou/TEST5
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.AssetType;
<<<<<<< HEAD
import com.example.demo.repository.AssetTypeRepository;

import javassist.expr.NewArray;
=======

import com.example.demo.repository.AssetTypeRepository;
>>>>>>> branch 'master' of https://github.com/isaibou/TEST5

@Controller
<<<<<<< HEAD
public class AssetTypeController
{
	@Autowired
	AssetTypeRepository assetTyperepository;
=======
public class AssetTypeController{
	
	@Autowired
	private AssetTypeRepository assettypeRepository;
>>>>>>> branch 'master' of https://github.com/isaibou/TEST5
	
	@RequestMapping(value="/assetstype_manage")
<<<<<<< HEAD
	public String Assetstype_Manage(Model model, AssetType assetType) {
		
	List<AssetType>	ListassetType = assetTyperepository.findAll();
	model.addAttribute("ListassetType" , ListassetType);
	model.addAttribute("assetType", new AssetType());
	
=======
	public String assetstype_manage(Model model) {
		
		List<AssetType> asstype = assettypeRepository.findAll();
		model.addAttribute("assetstype",asstype);
		
>>>>>>> branch 'master' of https://github.com/isaibou/TEST5
		return "assetstype_manage";
	}
	

}
