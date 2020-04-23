package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.AssetType;
import com.example.demo.entities.Frimware;
import com.example.demo.entities.Purchasing;
import com.example.demo.entities.RFP;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RFPRepository;

@Controller
public class RFPController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RFPRepository rfpRepository;
	
	@RequestMapping(value = "/RFP")
	public String AllRFP(Model model ) {
		
		List<RFP> rf = rfpRepository.findAll();
		model.addAttribute("rfp", rf);
		model.addAttribute("rf", new RFP());
		
		//Afficher la liste déroulante pour récupérer la liste des customers
		model.addAttribute("customer", customerRepository.findAll());
		
		return "RFP";
	}
	
	@RequestMapping(value="/SaveRFP" , method= RequestMethod.POST)
	private String SaveRFP(@Valid RFP addRfp, BindingResult bindingResult) {
		
		addRfp.setStatusRFP("Actif");
		
		rfpRepository.save(addRfp);
		return "redirect:/RFP";
		
	}
	
	@RequestMapping(value = "/editRFP",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateRFP(Model model, @Valid RFP RFP, BindingResult bindingResult){
		
		RFP.setStatusRFP("Actif");

		rfpRepository.save(RFP);
		
		return "redirect:/RFP";
	}
	
	@RequestMapping(value ="/updateRFP")
	public String updateRFPForm( Model model, Integer id ) {
		
		 RFP	rfp = rfpRepository.getOne(id);
		 model.addAttribute("rfp",rfp);
		 
		 model.addAttribute("customer", customerRepository.findAll());	
		 System.out.println(rfp.getTitle());
		
			return "updateRFPForm";
			
	}
	
	@RequestMapping(value ="/archiverRFP" )
	private String archiverRFP( Model model, Integer id ) {
	
		RFP rfp = rfpRepository.getOne(id);
		rfp.setStatusRFP("Archived");
		rfpRepository.save(rfp);
	    System.out.println(rfp.getStatusRFP());
		
			return "redirect:/RFP";	
			
	}
	
	@RequestMapping(value ="/detailRFP")
	public String detailRFP( Model model, Integer id ) {
		
		 RFP	rfp = rfpRepository.getOne(id);
		 model.addAttribute("RFP",rfp);
		 rfp.getCustomer().getName();
		 
	
		 //Affichage du customer qui j ai choisir a partir de la liste dérulante dans détail
		model.addAttribute("customer",  rfp.getCustomer());
		 //System.out.println(Purchasing.getFirstName());
		
			return "detailRFP";
			
	}
	
	
	}


