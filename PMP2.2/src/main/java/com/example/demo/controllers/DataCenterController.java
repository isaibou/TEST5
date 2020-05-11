package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.DataCenter;
import com.example.demo.entities.Purchasing;
import com.example.demo.entities.Users;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DataCenterRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class DataCenterController {
	
	@Autowired
	private DataCenterRepository dataCenterRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(value="/dataCenter")
	public String allDataCenter(Model model, Authentication auth, DataCenter dataCenter) {
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
		List<DataCenter> alldata = dataCenterRepository.findAll();
		model.addAttribute("allData",alldata);
		model.addAttribute("data", new DataCenter());
		
		//Afficher la liste déroulante pour récupérer la liste des customers
		model.addAttribute("customer", customerRepository.findAll());	
		model.addAttribute("totalData", alldata.size());
		
		return "dataCenter";
	}
	
	@RequestMapping(value="/SaveDataCenter" , method= RequestMethod.POST)
	private String SaveDataCenter(@Valid DataCenter dataCenter,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "addDataCenter";
		}
		dataCenterRepository.save(dataCenter);
		return "redirect:/dataCenter";
		
	}
	
	@RequestMapping(value ="/addDataCenter")
	public String addDataCenterForm( Model model) {
		model.addAttribute("customer", customerRepository.findAll());	
		model.addAttribute("data", new DataCenter());
			return "addDataCenter";
			
	}
	
	@RequestMapping(value = "/editDataCenter",method = RequestMethod.POST )
	public String updatePurchasing(DataCenter data){
		dataCenterRepository.save(data);	
		return "redirect:/dataCenter";
	}
	
	@RequestMapping(value ="/updateDataCenter")
	public String updatePurchasingtForm( Model model, Integer id ) {
		model.addAttribute("customer", customerRepository.findAll());	

		DataCenter data =  dataCenterRepository.getOne(id);
		model.addAttribute("data", data);
			return "updateDataCenter";
			
	}
	
	@RequestMapping(value ="/deleteDataCenter" )
	private String deleteDataCenter( Model model, Integer id ) {
	
		DataCenter data = dataCenterRepository.getOne(id);
		dataCenterRepository.delete(data);
		
		 return "redirect:/dataCenter";	
	}
	

	

}
