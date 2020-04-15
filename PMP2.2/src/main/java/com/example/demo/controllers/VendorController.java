package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Assets;
import com.example.demo.entities.Purchasing;
import com.example.demo.entities.Vendor;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.VendorRepository;

@Controller
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@RequestMapping(value="/vendor")
	public String vendor(Model model, Vendor vendor) {
		
		List<Vendor> vendo = vendorRepository.findAll();
		model.addAttribute("vend",vendo);
		model.addAttribute("vendor", new Vendor());
		
		return "vendor";
	}
	
	@RequestMapping(value="/SaveVendor" , method= RequestMethod.POST)
	private String SaveVendor(@Valid Vendor addVen, BindingResult bindingResult) {
		//addProj.setStatus("Actif");
		
		vendorRepository.save(addVen);
		return "redirect:/vendor";
		
	}
	
	@RequestMapping(value = "/editVendor",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateVendor(Model model, @Valid Vendor vend, BindingResult bindingResult){

		vendorRepository.save(vend);
		
		return "redirect:/vendor";
	}
	
	@RequestMapping(value ="/updateVendor")
	public String updateVendorForm( Model model, Integer id ) {
		
		Vendor	vendor = vendorRepository.getOne(id);
		 model.addAttribute("vendor",vendor);
		 
		
			return "updateVendorForm";
			
	}
	
	@RequestMapping(value ="/deleteVendor" )
	private String deleteVendor( Model model, Integer id ) {
	
		vendorRepository.deleteById(id);
		
		 return "redirect:/vendor";	
	}
	
	@RequestMapping(value ="/detailVendor")
	public String detailPurchasing( Model model, Integer id ) {
		
		Vendor	vendor = vendorRepository.getOne(id);
		 model.addAttribute("Vendor",vendor);
		
			return "detailVendor";
			
	}

}
