package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.TechnologyPartner;
import com.example.demo.entities.Vendor;
import com.example.demo.repository.TechnologiePartnerRepository;

@Controller
public class TechnologyPartnerController {
	
	@Autowired
	private TechnologiePartnerRepository technologiepartnerRepository;
	
	@RequestMapping(value="/Technology_Partner")
	public String TechnologyPartner(Model model, TechnologyPartner technologypartne) {
		
		List<TechnologyPartner> technologypartner = technologiepartnerRepository.findAll();
		model.addAttribute("techpart",technologypartner );
		model.addAttribute("technopart", new TechnologyPartner());
	
		return "Technology_Partner";
	}
	
	@RequestMapping(value="/SaveTechnologyPartner" , method= RequestMethod.POST)
	private String SaveTechnologyPartner(@Valid TechnologyPartner addTechnologyPart, BindingResult bindingResult) {
		addTechnologyPart.setStatus("Actif");
		
		technologiepartnerRepository.save(addTechnologyPart);
		return "redirect:/Technology_Partner";
		
	}
	
	@RequestMapping(value = "/editTechnologyPartner",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateTechnologyPartner(Model model, @Valid TechnologyPartner technologypart, BindingResult bindingResult){
        
		technologypart.setStatus("Actif");
		technologiepartnerRepository.save(technologypart);
		
		return "redirect:/Technology_Partner";
	}
	
	@RequestMapping(value ="/updateTechnologyPartner")
	public String updateTechnologyPartnerForm( Model model, Integer id ) {
		
		TechnologyPartner	technologypartner = technologiepartnerRepository.getOne(id);
		 model.addAttribute("techpar",technologypartner);
		 
		
			return "updateTechnPartnForm";
			
	}
	
	@RequestMapping(value ="/archiverTechnologyPartner" )
	private String archiverTechnologyPartner( Model model, Integer id ) {
	
		TechnologyPartner technologypartner = technologiepartnerRepository.getOne(id);
		technologypartner.setStatus("Archived");
		technologiepartnerRepository.save(technologypartner);
	    System.out.println(technologypartner.getStatus());
		
			return "redirect:/Technology_Partner";	
			
	}
	
	@RequestMapping(value ="/detailTechnologyPartner")
	public String detailTechnologyPartner( Model model, Integer id ) {
		
		 TechnologyPartner	technologypartner = technologiepartnerRepository.getOne(id);
		 model.addAttribute("technolgpartn",technologypartner);
		
			return "detailTechnologyPartner";
			
	}

}
