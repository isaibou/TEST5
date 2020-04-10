package com.example.demo.controllers;

import java.util.Date;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.*;
import com.example.demo.repository.AssetTypeRepository;

@Controller

public class AssetTypeController
{

	@Autowired
	private AssetTypeRepository assetTypeRepository;
     
	
	@RequestMapping(value="/assetstype_manage")
	public String allAssetType(Model model, AssetType assettype) {
		
		List<AssetType> assettyp = assetTypeRepository.findAll();
		model.addAttribute("asstyp", assettyp);
		model.addAttribute("assetstype", new AssetType());
		
		model.addAttribute("totalAssetType", assettyp.size());
		
		return "assetstype_manage";
		
	}
	
	
	@RequestMapping(value="/SaveAssetType" , method= RequestMethod.POST)
	private String saveAssetType(@Valid AssetType addAssttyp, BindingResult bindingResult) {
		
		addAssttyp.setStatus("Actif");
	
		assetTypeRepository.save(addAssttyp);
		return "redirect:/assetstype_manage";
			
	}
		
	
	@RequestMapping(value ="/updateAseetTypeform" )
	private String updateAseetTypeform( Model model, Integer id ) {
	AssetType	assettype = assetTypeRepository.getOne(id);
		 model.addAttribute("assetstype",assettype);
		 System.out.println(assettype.getName());
		
			return "updateAseetTypeForm";
			
	}
	
	@RequestMapping(value = "/editAseetType",method= RequestMethod.POST)
	public String updateAseetType(Model model, AssetType assetT){
		
		assetTypeRepository.save(assetT);
		
		return "redirect:/assetstype_manage";
	}
	
	//@RequestMapping(value ="/archiverAseetType" )
	//private String archiverAseetType( Model model, Integer id ) {
	
	//AssetType AssTyp = assetTypeRepository.getOne(id);
	//AssTyp.setStatus("Archived");
	//AssTyp.setName("Sara");
	//assetTypeRepository.save(AssTyp);
	//System.out.println(AssTyp.getStatus());
		
			//return "redirect:/assetstype_manage";	
			
	//}


	@RequestMapping(value ="/deleteAssetType" )
	private String deleteAssetType( Model model, Integer id ) {
	
		assetTypeRepository.deleteById(id);
		
		 return "redirect:/assetstype_manage";	
	}
}
