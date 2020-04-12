package com.example.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;

import com.example.demo.entities.*;
import com.example.demo.repository.CustomerRepository;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerrepository; 
	
	@Value("${storage.location}")
	private String StorageLocation;
	
	@RequestMapping(value="/customer_manage")
	public String AllCustomer(Model model, Customer customer) {
		
		List<Customer> custs = customerrepository.findAll();
		model.addAttribute("cust", custs);
		model.addAttribute("customer", new Customer());
		
		return "customer_manage";
	}

    @RequestMapping(value="/admin/SaveCustomer" , method= RequestMethod.POST)
	private String SaveCustomer(@Valid Customer addCust, BindingResult bindingResult, @RequestParam(name="picture")MultipartFile file) {
		
		/*if(bindingResult.hasErrors()) {
			return "customer_manage";
		}*/
		
		if(!(file.isEmpty())) {
			addCust.setLogo(file.getOriginalFilename());
			addCust.setStatus("Actif");
			customerrepository.save(addCust);
			try {		
				//file.transferTo(new File(StorageLocation+ addCust.getCustomer_ID()));
				File f=new File(StorageLocation+ "/"+ addCust.getCustomer_ID());
				System.out.println(f.getAbsolutePath());
				file.transferTo(f);
				addCust.setLogo(file.getOriginalFilename());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return "redirect:/customer_manage";	
	}
	
	@RequestMapping(value="/getLogo",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getLogo(Integer Customer_ID) {
		try {
			File f=new File(StorageLocation + Customer_ID);
			return IOUtils.toByteArray(new FileInputStream(f));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new byte[0] ;	 
	}
	
	@RequestMapping(value ="updateCustomerform" )
	private String updateCustomerform( Model model, Integer id ) {
	Customer customer = customerrepository.getOne(id);
		 model.addAttribute("customer",customer);
		 System.out.println(customer.getName());
		
			return "updateCustomerForm";
			
	}
	
    @RequestMapping(value = "/admin/editCustomer",method= RequestMethod.POST)
	private String updateCustomer(Model model, @Valid Customer addCust, BindingResult bindingResult, @RequestParam(name="picture")MultipartFile file) {

	/*if (bindingResult.hasErrors()) {
		return "updateCustomerForm";
	}*/
		if(!(file.isEmpty())) {
			addCust.setLogo(file.getOriginalFilename());
			addCust.setStatus("Actif");
			customerrepository.save(addCust);
			try {		
				//file.transferTo(new File(StorageLocation+ addCust.getCustomer_ID()));
				File f=new File(StorageLocation+ "/"+ addCust.getCustomer_ID());
				System.out.println(f.getAbsolutePath());
				file.transferTo(f);
				addCust.setLogo(file.getOriginalFilename());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return "redirect:/customer_manage";
	}
    
	@RequestMapping(value ="/detailCustomer")
	public String detailCustomer( Model model, Integer id ) {
		Customer customer = customerrepository.getOne(id);
		 model.addAttribute("customer",customer);
		 System.out.println(customer.getName());	
			return "detailCust";
			
	}
	
	@RequestMapping(value ="/archiverCustomer" )
	private String archiverCustomer( Model model, Integer id ) {
	
	Customer Cust = customerrepository.getOne(id);
	Cust.setStatus("Archived");

	customerrepository.save(Cust);
	
		
			return "redirect:/customer_manage";	
			
}

}
 	