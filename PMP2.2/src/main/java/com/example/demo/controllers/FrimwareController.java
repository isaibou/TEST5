
package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Frimware;
import com.example.demo.entities.Project;
import com.example.demo.entities.RFP;
import com.example.demo.entities.Users;
import com.example.demo.repository.AssetTypeRepository;
import com.example.demo.repository.FrimwareRepository;
import com.example.demo.repository.UserRepository;


@Controller
public class FrimwareController {
	
	@Autowired
	private AssetTypeRepository assetTypeRepository;
	
	@Autowired
	private FrimwareRepository frimwareRepository;
	@Autowired
	private UserRepository userRepository;
	

	
	@RequestMapping(value = "/firmware")
	public String AllFrimware(Model model, Frimware frimware, Authentication auth) {
		
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
		List<Frimware> frime = frimwareRepository.findAll();
		model.addAttribute("frim", frime);
		model.addAttribute("frimware", new Frimware());
		
		//cette methode pour claculet le totale de frimware et aprés on ajoute un truc dans la page htlm.
		model.addAttribute("totalFirmware", frime.size());
		
		List<Frimware> frimwareActif = frimwareRepository.findByStatus("Actif");
		model.addAttribute("totalfrimwareActif", frimwareActif.size());
		
		List<Frimware> frimwareArchived = frimwareRepository.findByStatus("Archived");
		model.addAttribute("totalfrimwareArchived", frimwareArchived.size());
		
		model.addAttribute("assettype", assetTypeRepository.findAll());
		
		return "firmware";
	}
	
	@RequestMapping(value="/SaveFrimware" , method= RequestMethod.POST)
	private String SaveFrimware(@Valid Frimware addFrim, BindingResult bindingResult, Model model) {
		
		if(frimwareRepository.checkTitleExist(addFrim.getName())) {
			//System.err.println("checkTitleExist-------------------");
			model.addAttribute("unique", "must be unique");
			return "addFirmware";
		}
		
		if(bindingResult.hasErrors()) {
			return "addFirmware";
			
		}
		
		addFrim.setStatus("Actif");
		
		//System.out.println("name ="+addFrim.getAssettype().get(0).getName());
	
		frimwareRepository.save(addFrim);
		return "redirect:/firmware";
	}
	
	@RequestMapping(value ="/addFirmware" )
	private String addFirmware( Model model ) {
		
	     
		 model.addAttribute("frimware",frimwareRepository.findAll());
		
		 model.addAttribute("frimware", new Frimware());
		 
		 model.addAttribute("assetType", assetTypeRepository.findAll());
		 
		 return "addFirmware";
			
	}
	
	
	@RequestMapping(value ="/updateFrimwareform" )
	private String updateFrimwareform( Model model, Integer id ) {
		
	     Frimware	frimware = frimwareRepository.getOne(id);
		 model.addAttribute("frimware",frimware);
		 System.out.println(frimware.getName());
		 
		 model.addAttribute("assetType", assetTypeRepository.findAll());
		 
		 return "updateFrimwareForm";
			
	}
	
	@RequestMapping(value = "/editFrimware",method= RequestMethod.POST)
	public String updateFrimware(Model model, Frimware frim){
	
		
	    frim.setStatus("Actif");
	    System.out.println(frim.getFrimware_ID());
		frimwareRepository.save(frim);
		System.out.println(frim.getFrimware_ID());
		
		return "redirect:/firmware";
		
	}
	
	@RequestMapping(value ="/archiverFrimware" )
	private String archiverCustomer( Model model, Integer id ) {
	
		Frimware Frim = frimwareRepository.getOne(id);
		Frim.setStatus("Archived");
	    frimwareRepository.save(Frim);
	    System.out.println(Frim.getStatus());
		

			return "redirect:/firmware";	
			}

			
	
	@RequestMapping(value ="/detailFrimware")
	public String detailFrimware( Model model, Integer id ) {
		
		 Frimware	frimware = frimwareRepository.getOne(id);
		 model.addAttribute("frimware",frimware);
		
		 System.out.println(frimware.getName());
		 
		 model.addAttribute("assettype", assetTypeRepository.findAll());
		
			return "detailFrimware";
			
	}
	


}

	    		
	 
	
	
		
		
		




