package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.*;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;
import com.example.demo.repository.FrimwareRepository;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.UserRepository;


@Controller
public class AssetsController {
	
	@Autowired
	private FrimwareRepository frimwareRepository;
	
	@Autowired
	private ProjetRepository projetRepository;
	
	@Autowired
	private AssetTypeRepository assetTypeRepository;
	
	@Autowired
	private AssetRepository assetRepository;
	@Autowired
	private UserRepository userRepository;
	
	//@Secured(value = "ROLE_MANAGER")
	@RequestMapping(value="/assets_manage")
	public String allAsset(Model model, Assets asset, Authentication auth) {
		
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
		List<Assets> assets = assetRepository.findAll();
		model.addAttribute("asset", assets);
		//model.addAttribute("assets", new Assets());
		
		model.addAttribute("assettype", assetTypeRepository.findAll());
		model.addAttribute("project", projetRepository.findAll());
		model.addAttribute("frimware", frimwareRepository.findAll());
		/*
		 * List<RFP> rfpee = (List<RFP>) u.getCustomer().getRfp(); List<Project> proj =
		 * (List<Project>) ((RFP) rfpee).getProject(); ((Project) proj).getAssets();
		 * 
		 */
		return "assets_manage";
	}
	
	@RequestMapping(value="/SaveAssets" , method= RequestMethod.POST)

	private String SaveAssets(@Valid Assets addAss, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "addAssets";}
			
		}
		

	private String SaveAssets(@Valid Assets addAss, BindingResult bindingResult, Model model) {

		addAss.setStatus("Actif");
		
		assetRepository.save(addAss);
		AssetType asstype=  addAss.getAssettype();
		System.out.println(asstype);
		//List<Frimware> frim = asstype.getFrimware();
		model.addAttribute("frimware", asstype.getFrimware());
		System.out.println(asstype.getFrimware());
		//System.out.println(frim);
		Integer i =  addAss.getAssets_ID();
		System.out.println(i);
		model.addAttribute("id", i);
		
		return "nextAsset"; //$NON-NLS-1$
		
		
	}
	
	@RequestMapping(value="/addAssets" , method= RequestMethod.POST)
	private String addAssets(Integer id, @RequestParam(name="frim") Frimware frim  ) {
		
		Assets asset = assetRepository.getOne(id);
		asset.setFrimware(frim);
		assetRepository.save(asset);
		
		
		return "redirect:/assets_manage"; //$NON-NLS-1$
		
	}
	

	@RequestMapping(value ="/addAssets")
	public String addAssets( Model model, Integer id ) {
		
		 model.addAttribute("assets",  assetRepository.findAll());
		 model.addAttribute("assets", new Assets());
		 model.addAttribute("assettype", assetTypeRepository.findAll());
		 model.addAttribute("project", projetRepository.findAll());	
		
			return "addAssets";
			
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
		
		 
		//Affichage du asse type et project qui j ai choisir a partir de la liste dérulante dans détail
		// model.addAttribute("assettype", assets.getAssettype());
		 //model.addAttribute("project", assets.getProject());
	
	
			return "detailAssets";
			
	}
	
	
}
