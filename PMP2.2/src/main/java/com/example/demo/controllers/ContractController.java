package com.example.demo.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.*;

import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RFPRepository;



@Controller
public class ContractController {
	
	 
	
	@Autowired
	private RFPRepository rfpRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ContratRepository contratrepository; 
	

	@Value("${dir.contrat}")
	private String contratfile;
	
	@RequestMapping(value="/contract_manage")
	public String ContractManage(Model model, Contrat contrat ) {
		
		List<Contrat> contra = contratrepository.findAll();
		model.addAttribute("con", contra);
		model.addAttribute("contrat", new Contrat());
		
		//Afficher la liste déroulante pour récupérer la liste des customers
		model.addAttribute("customer", customerRepository.findAll());
		model.addAttribute("rfp", rfpRepository.findAll());
		
		return "contract_manage";
	}
	
	@RequestMapping(value="/SaveContrat" , method= RequestMethod.POST)
	private String SaveContrat(@Valid Contrat addCont, BindingResult bindingResult , @RequestParam(name="contractFile")MultipartFile file) throws IllegalStateException, IOException
	{
		
		
		
		
if (!(file.isEmpty())) {
			
			addCont.setContractFille((file.getOriginalFilename()));

			file.transferTo(new File(contratfile+file.getOriginalFilename()));
		}

		
	
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
		 model.addAttribute("rfp", rfpRepository.findAll());
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
		 contrat.getRfp().getTitle();
		 
	
		 //Affichage du customer qui j ai a partir de la liste dérulante dans détail
		model.addAttribute("customer",  contrat.getCustomer());
		model.addAttribute("rfp", rfpRepository.findAll());
		 
		
			return "detailContrat";
			
	}
}
