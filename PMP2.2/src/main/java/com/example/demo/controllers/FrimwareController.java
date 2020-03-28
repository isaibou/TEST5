package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entities.Frimware;
import com.example.demo.repository.FrimwareRepository;

@Controller
public class FrimwareController {
	
		
		@Autowired
		private FrimwareRepository frimwareRepository;
		
		@RequestMapping(value="/firmware")
		public String Allfrimware(Model model, Frimware frimware) {
			
			List<Frimware> frimwar = frimwareRepository.findAll();
			model.addAttribute("frim",frimwar);
			model.addAttribute("frimware", new Frimware());
			
			return "firmware";
	}
		//les deux methode post et get
		
	
		
		@RequestMapping(value="/Savefirmware" , method= RequestMethod.POST)
		public String Savefirmware(Frimware frimware) {
			frimwareRepository.save(frimware);
			return "redirect:/firmware";
			
		}
		
}
		


