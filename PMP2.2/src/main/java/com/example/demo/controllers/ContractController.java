package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.*;

import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.CustomerRepository;



@Controller
public class ContractController {
	
	// Ici on a besoin de déclarer le repository du customer pour avoir
		//appeller a le modéle qui va afficher la liste déroulante 
		@Autowired
		private CustomerRepository customerRepository;

	@Autowired
	private ContratRepository contratrepository; 
	
	@RequestMapping(value="/contract_manage")
	public String ContractManage(Model model, Contrat contrat ) {
		
		List<Contrat> contra = contratrepository.findAll();
		model.addAttribute("con", contra);
		model.addAttribute("contrat", new Contrat());
		
		//Afficher la liste déroulante pour récupérer la liste des customers
		model.addAttribute("customer", customerRepository.findAll());	
		
		return "contract_manage";
	}
	
	@RequestMapping(value="/SaveContrat" , method= RequestMethod.POST)
	private String SaveContrat(@Valid Contrat addCont, BindingResult bindingResult) {
		
		//addCust.setStatus("Actif");
	
		contratrepository.save(addCont);
		return "redirect:/contract_manage";
		
	}
	
	@RequestMapping(value = "/editContrat",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateContrat(Model model, @Valid Contrat con, BindingResult bindingResult){

		contratrepository.save(con);
		
		return "redirect:/contract_manage";
	}
	
	@RequestMapping(value ="/updateContrat")
	public String updateContratForm( Model model, Integer id ) {
		
		Contrat	contrat = contratrepository.getOne(id);
		 model.addAttribute("contrat",contrat);
		 
		 model.addAttribute("customer", customerRepository.findAll());	
		 System.out.println(contrat.getTitle());
		
			return "updateContratForm";
			
	}
	
	@RequestMapping(value ="/deleteContrat" )
	private String deleteContrat( Model model, Integer id ) {
	
		contratrepository.deleteById(id);
		
		 return "redirect:/contract_manage";	
	}
	
	@RequestMapping(value ="/detailContrat")
	public String detailContrat( Model model, Integer id ) {
		
		 Contrat	contrat = contratrepository.getOne(id);
		 model.addAttribute("contrat",contrat);
		 contrat.getCustomer().getName();
		 
	
		 //Affichage du customer qui j ai a partir de la liste dérulante dans détail
		model.addAttribute("customer",  contrat.getCustomer());
		 //System.out.println(Purchasing.getFirstName());
		
			return "detailContrat";
			
	}
}
