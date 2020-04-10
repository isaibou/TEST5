package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Assets;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Project;
import com.example.demo.entities.Purchasing;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PurchisingRepository;

@Controller
public class PurchasingController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PurchisingRepository purchisingRepository;
	
	
	@RequestMapping(value="/purchasing_customer_manage")
	public String allPurString(Model model, Purchasing purchasing) {
		
		List<Purchasing> purcha = purchisingRepository.findAll();
		model.addAttribute("purch",purcha);
		model.addAttribute("purchasing", new Purchasing());
		
		//la liste déroulante pour récupérer la liste des customers
		model.addAttribute("customer", customerRepository.findAll());		
		return "purchasing_customer_manage";
	
	}
	
	@RequestMapping(value="/SavePurchasing" , method= RequestMethod.POST)
	private String SavePurchasing(@Valid Purchasing addPur, BindingResult bindingResult) {
		//addProj.setStatus("Actif");
		
		purchisingRepository.save(addPur);
		return "redirect:/purchasing_customer_manage";
		
	}
	
	@RequestMapping(value = "/editPurchasing",method = { RequestMethod.GET, RequestMethod.POST })
	public String updatePurchasing(Model model, @Valid Purchasing purch, BindingResult bindingResult){

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
		 
	
		 //affichage du customer qui j ai a partir de la liste dérulante dans détail
		model.addAttribute("customer",  purchasing.getCustomer());
		 //System.out.println(Purchasing.getFirstName());
		
			return "detailPurchasing";
			
	}
}
	



