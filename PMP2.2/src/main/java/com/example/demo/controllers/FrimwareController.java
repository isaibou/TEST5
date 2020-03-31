
package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.repository.FrimwareRepository;

@Controller
public class FrimwareController {
	@Autowired
	private FrimwareRepository frimwareRepository;
	

	@RequestMapping(value = "/firmware")
	public String AllFrimware(Model model, Frimware frimware) {
		
		List<Frimware> frime = frimwareRepository.findAll();
		model.addAttribute("frim", frime);
		model.addAttribute("frimware", new Frimware());
		model.addAttribute("totalFirmware", frime.size());
		
		return "firmware";
	}
	
	@RequestMapping(value="/SaveFrimware" , method= RequestMethod.POST)
	private String SaveFrimware(@Valid Frimware addFrim, BindingResult bindingResult) {
		
		
		addFrim.setStatus("Actif");
	
		frimwareRepository.save(addFrim);
		return "redirect:/firmware";
	}
	
	@RequestMapping(value ="/updateFrimwareform" )
	private String updateFrimwareform( Model model, Integer id ) {
		
	Frimware	frimware = frimwareRepository.getOne(id);
		 model.addAttribute("frimware",frimware);
		 System.out.println(frimware.getName());
		
			return "updateFrimwareForm";
			
	}
	
	@RequestMapping(value = "/editFrimware",method= RequestMethod.POST)
	public String updateFrimware(Model model, Frimware frim){
	frim= 	(Frimware) model.getAttribute("frimware");
		frimwareRepository.save(frim);
		
		return "redirect:/firmware";
	}
	
	
	@RequestMapping(value ="/archiverFrimware" )
	private String archiverFrimware( Model model, Integer id ) {
	
	Frimware Frim = frimwareRepository.getOne(id);
	Frim.setStatus("Archived");
	Frim.setName("Sarah");
	frimwareRepository.save(Frim);
	System.out.println(Frim.getStatus());
		
			return "redirect:/firmware";	}
}

	    		
	 
	
	
		
		
		




