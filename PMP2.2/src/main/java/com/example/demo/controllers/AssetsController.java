package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.*;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;
import com.example.demo.repository.ProjetRepository;


@Controller
public class AssetsController {
	
	@Autowired
	private ProjetRepository projetRepository;
	
	@Autowired
	private AssetTypeRepository assetTypeRepository;
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Secured(value = "ROLE_MANAGER")
	@RequestMapping(value="/assets_manage")
	public String allAsset(Model model, Assets asset) {
		
		List<Assets> assets = assetRepository.findAll();
		model.addAttribute("asset", assets);
		model.addAttribute("assets", new Assets());
		
		model.addAttribute("assettype", assetTypeRepository.findAll());
		model.addAttribute("project", projetRepository.findAll());
		
		return "assets_manage";
	}
	
	@RequestMapping(value="/SaveAssets" , method= RequestMethod.POST)
	private String SaveAssets(@Valid Assets addAss, BindingResult bindingResult) {
		addAss.setStatus("Actif");
		
		assetRepository.save(addAss);
		return "redirect:/assets_manage";
		
	}
	@RequestMapping(value = "/editAssets",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateAssets(Model model, @Valid Assets asset, BindingResult bindingResult){
       
		asset.setStatus("Actif");
		assetRepository.save(asset);
		
		return "redirect:/assets_manage";
	}
	
	@RequestMapping(value ="/updateAssets")
	public String updateAssetsForm( Model model, Integer id ) {
		
		 Assets	assets = assetRepository.getOne(id);
		 model.addAttribute("assets",  assets);
		 
		 model.addAttribute("assettype", assetTypeRepository.findAll());
		 model.addAttribute("project", projetRepository.findAll());	
		 
		 //System.out.println(purchasing.getFirstName());
		
			return "updateAssetsForm";
			
	}
	
	@RequestMapping(value ="/archiverAssets" )
	private String archiverAssets( Model model, Integer id ) {
	
		Assets assets = assetRepository.getOne(id);
		assets.setStatus("Archived");
		assetRepository.save(assets);
	    System.out.println(assets.getStatus());
		
			return "redirect:/assets_manage";	
			
	}
	
	@RequestMapping(value ="/detailAssets")
	public String detailAssets( Model model, Integer id ) {
		
		 Assets	assets = assetRepository.getOne(id);
		 model.addAttribute("Assets",assets);
		 assets.getAssettype().getName();
		 assets.getProject().getName();
		 
		//Affichage du asse type et project qui j ai choisir a partir de la liste dérulante dans détail
		 model.addAttribute("assettype", assets.getAssettype());
		 model.addAttribute("project", assets.getProject());
	
	
			return "detailAssets";
			
	}
	
	
}
