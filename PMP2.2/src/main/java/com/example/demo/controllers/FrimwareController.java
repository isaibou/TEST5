
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
import com.example.demo.entities.Frimware;
import com.example.demo.repository.FrimwareRepository;

@Controller
public class FrimwareController {

	@Autowired
	private FrimwareRepository frimwareRepository;

	@RequestMapping(value = "/firmware")
	public String frimware(Model model) {

		List<Frimware> frimwareList = frimwareRepository.findAll();
		model.addAttribute("firmList", frimwareList);
		
		model.addAttribute("totalFirmware", frimwareList.size());

		model.addAttribute("obj", new Frimware());

		return "firmware";
	}

	@PostMapping("/addFirmware")
    public String addUser(@Valid Frimware obj, BindingResult result, Model model) {
       
         
        frimwareRepository.save(obj);
      
        List<Frimware> frimwareList = frimwareRepository.findAll();
        model.addAttribute("firmList", frimwareList);
        
//cette méthode pour calculer le totale de frimware
		model.addAttribute("totalFirmware", frimwareList.size());

		model.addAttribute("obj", new Frimware());
        return "redirect:/firmware";
    }
	@PostMapping("/update/{id}")
	public String updateFrimware(@PathVariable("id") Integer id, @Valid Frimware frimware, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        frimware.setFrimware_ID(id);
	        return "update-Frimware";
	    }
	         
	    frimwareRepository.save(frimware);
	    model.addAttribute("frimwareList", frimwareRepository.findAll());
	    return "redirect:/firmware";
	}
	 
	
	
		
		
		

}


