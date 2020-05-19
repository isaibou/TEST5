package com.example.demo.controllers;

import java.util.Date;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.*;
import com.example.demo.repository.AssetTypeRepository;
import com.example.demo.repository.FrimwareRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VendorRepository;


@Controller

public class AssetTypeController
{

	
	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private AssetTypeRepository assetTypeRepository;
	@Autowired
	private UserRepository userRepository;
    
	
	
	@RequestMapping(value="/assetstype_manage")
	public String allAssetType(Model model, AssetType assettype, Authentication auth) {
		
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
		List<AssetType> assettyp = assetTypeRepository.findAll();
		 model.addAttribute("totalAssetType", assettyp.size());
		model.addAttribute("asstyp", assettyp);
	//	model.addAttribute("AssetType", new AssetType());
		
		model.addAttribute("totalAssetType", assettyp.size());
		
		
		model.addAttribute("vendor", vendorRepository.findAll());
		
		return "assetstype_manage";
		
	}
	
	
	@RequestMapping(value="/SaveAssetType" , method= RequestMethod.POST)
	private String saveAssetType(@Valid AssetType addAssttyp, BindingResult bindingResult, Model model) {
		
		if(assetTypeRepository.checkTitleExist(addAssttyp.getName())) {
			//System.err.println("checkTitleExist-------------------");
			model.addAttribute("unique", "must be unique");
			return "addAssetsType";
		}
		
		if(bindingResult.hasErrors()) {
			return "addAssetsType";
			
		}
		
		addAssttyp.setStatus("Actif");
	
		assetTypeRepository.save(addAssttyp);
		return "redirect:/assetstype_manage";
			
	}
	
	@RequestMapping(value ="/addAssetsType" )
	private String addAssetsType( Model model ) {
		
	   
		 model.addAttribute("assetstype",assetTypeRepository.findAll());
		 
		 model.addAttribute("assetType", new AssetType());
		
		 model.addAttribute("vendor", vendorRepository.findAll());
		
			return "addAssetsType";
			
	}
		
	
	@RequestMapping(value ="/updateAseetTypeform" )
	private String updateAseetTypeform( Model model, Integer id ) {
		
	     AssetType	assettype = assetTypeRepository.getOne(id);
		 model.addAttribute("assetstype",assettype);
		 
	
		 model.addAttribute("vendor", vendorRepository.findAll());
		 
		 System.out.println(assettype.getName());
		
			return "updateAseetTypeForm";
			
	}
	
	@RequestMapping(value = "/editAseetType",method= RequestMethod.POST)
	public String updateAseetType(Model model, AssetType assetT){
		
		assetT.setStatus("Actif");
		assetTypeRepository.save(assetT);
		
		return "redirect:/assetstype_manage";
	}
	
	@RequestMapping(value ="/archiverAseetT" )
	private String archiverCustomer( Model model, Integer id ) {
	
		AssetType Assttyp = assetTypeRepository.getOne(id);
		Assttyp.setStatus("Archived");
		assetTypeRepository.save(Assttyp);
	    System.out.println(Assttyp.getStatus());
		
			return "redirect:/assetstype_manage";	}
	
	@RequestMapping(value ="/detailAseetType")
	public String detailAseetT( Model model, Integer id ) {
		
		 AssetType	assettype = assetTypeRepository.getOne(id);
		 model.addAttribute("assettype",assettype);

	//	 model.addAttribute("vendor", vendorRepository.findAll());
		
		
		 System.out.println(assettype.getName());

		
			return "detailAseetType";
		
	}		

	}
			

	

