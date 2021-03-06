package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Assets;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Project;
import com.example.demo.entities.Purchasing;
import com.example.demo.entities.Users;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PurchisingRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class PurchasingController {
	// voila Ici on a besoin de déclarer le repository du customer pour avoir, 
	//appeller a le modéle qui va afficher la liste déroulante. 
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PurchisingRepository purchisingRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value="/purchasing_customer_manage")
	public String allPurString(Model model, Authentication auth, Purchasing purchasing) {
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
		List<Purchasing> purcha = purchisingRepository.findAll();
		model.addAttribute("purch",purcha);
	//	model.addAttribute("purchasing", new Purchasing());
		
		//Afficher la liste déroulante pour récupérer la liste des customers
		model.addAttribute("customer", customerRepository.findAll());	
		model.addAttribute("totalCPurchasing", purcha.size());
		return "purchasing_customer_manage";
	
	}
	
	@RequestMapping(value="/SavePurchasing" , method= RequestMethod.POST)
	private String SavePurchasing(@Valid Purchasing addPur, BindingResult bindingResult,Model model) {
		
		if(purchisingRepository.checkTitleExist(addPur.getEmail())) {
			model.addAttribute("customer", customerRepository.findAll());
			
			model.addAttribute("unique", "must be unique");
			return "addpurchasing";
		}
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("customer", customerRepository.findAll());
			return "addpurchasing";
			
		}
		//addProj.setStatus("Actif");
		
		purchisingRepository.save(addPur);
		return "redirect:/purchasing_customer_manage";
		
	}
	@RequestMapping(value ="/addPurchasing")
	public String addpurchasing( Model model, Integer id ) {
		
		 
		 model.addAttribute("purchasing",purchisingRepository.findAll());
		 model.addAttribute("purchasing", new Purchasing());
		 model.addAttribute("customer", customerRepository.findAll());	
		
		
			return "addpurchasing";
			
	}
	
	@RequestMapping(value = "/editPurchasing",method = { RequestMethod.GET, RequestMethod.POST })
	public String updatePurchasing(Model model, @Valid Purchasing purch, BindingResult bindingResult){
		
		if(purchisingRepository.checkTitleExist(purch.getEmail())) {

			model.addAttribute("customer", customerRepository.findAll());
			
			List<Purchasing> purchasingDouble = purchisingRepository.searchByEmail(purch.getEmail());
	  		if(purch.getPurchasing_ID().equals(purchasingDouble.get(0).getPurchasing_ID())) {
	  			System.out.println("edited name is the same old email");
	  		}else {
			
			model.addAttribute("unique", "must be unique");
			return "updatePurchasingtForm";
		}
		}
		purchisingRepository.save(purch);
		
		return "redirect:/purchasing_customer_manage";
	}
	
	@RequestMapping(value ="/updatePurchasing")
	public String updatePurchasingtForm( Model model, Integer id ) {
		
		 Purchasing	purchasing = purchisingRepository.getOne(id);
		 model.addAttribute("purchasing",purchasing);
		 
		 model.addAttribute("customer", customerRepository.findAll());	
		 System.out.println(purchasing.getFirstName());
		
			return "updatePurchasingtForm";
			
	}
	
	@RequestMapping(value ="/deletePurchasing" )
	private String deletePurchasing( Model model, Integer id ) {
	
		purchisingRepository.deleteById(id);
		
		 return "redirect:/purchasing_customer_manage";	
	}
	
	@RequestMapping(value ="/detailPurchasing")
	public String detailPurchasing( Model model, Integer id ) {
		
		Purchasing	purchasing = purchisingRepository.getOne(id);
		 model.addAttribute("Purchasing",purchasing);
		 purchasing.getCustomer().getName();
		 
	


		 //Affichage du customer qui j ai a partir de la liste dérulante dans détail

		model.addAttribute("customer",  purchasing.getCustomer());
		 //System.out.println(Purchasing.getFirstName());
		
			return "detailPurchasing";
			
	}
}
	



