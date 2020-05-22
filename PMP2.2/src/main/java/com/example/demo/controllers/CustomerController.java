package com.example.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.entities.Customer;
import com.example.demo.entities.RFP;
import com.example.demo.entities.Users;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.customerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerrepository;
	@Autowired
	private UserRepository userRepository;

	private customerService customerService;

	@Value("${dir.logo}")
	private String images;

	@RequestMapping(value = "/customer_manage")
	public String AllCustomer(Model model, Authentication auth) {
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
		List<Customer> custs = customerrepository.findAll();
		model.addAttribute("cust", custs);
		model.addAttribute("customer", new Customer());

		model.addAttribute("custs", customerrepository.findAll());  

		model.addAttribute("totalCustomer", custs.size());
		
		List<Customer> customerActif = customerrepository.findByStatus("Actif");
		model.addAttribute("totalcustomerActif", customerActif.size());
		
		List<Customer> customerArchived = customerrepository.findByStatus("Archived");
		model.addAttribute("totalcustomerArchived", customerArchived.size());
		
		List<Customer> vip = customerrepository.findByVip("YES");
		model.addAttribute("vip", vip.size());
		
		return "customer_manage";
	}

	@RequestMapping(value = "/SaveCustomer", method = RequestMethod.POST)
	private String SaveCustomer(@Valid @ModelAttribute("customer") Customer addCust, BindingResult bindingResult, Model model,
			@RequestParam(name = "picture") MultipartFile file) throws Exception, IOException {
		
		if(customerrepository.checkTitleExist(addCust.getName())) {
			//System.err.println("checkTitleExist-------------------");
			model.addAttribute("unique", "must be unique");
			return "addCust";
		}
	
		if(bindingResult.hasErrors()) {
			return "addCust";
		}
		
		if (!(file.isEmpty())) {
			addCust.setLogo(file.getOriginalFilename());
			System.out.println(addCust.getLogo());
		}
		addCust.setStatus("Actif");
		customerrepository.save(addCust);
		System.out.println(addCust.getLogo());

		if (!(file.isEmpty())) {
			
			addCust.setLogo(file.getOriginalFilename());
			System.out.println(addCust.getLogo());

			file.transferTo(new File(images+addCust.getLogo()));
		}
		
		customerrepository.save(addCust);


		return "redirect:/customer_manage";
	}
	
	@RequestMapping(value="/getLogo" , produces= MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	private byte[] getLogo(String id) throws  IOException {
		File f = new File(images+id);
		return  IOUtils.toByteArray(new FileInputStream(f));
	}
	
	@RequestMapping(value ="addCust" ) 
	private String addCust( Model model) {
		model.addAttribute("customer",new Customer());
		return "addCust";			
	}

	  @RequestMapping(value ="updateCustomerform" ) 
		private String updateCustomerform( Model model, Integer id ) {
			Customer customer = customerrepository.getOne(id);
			model.addAttribute("customer",customer);
			System.out.println(customer.getName());
			return "updateCustomerForm";			
		}
	  
	  @RequestMapping(value = "/editCustomer",method= RequestMethod.POST) 
	  private String updateCustomer(@Valid Customer addCust, BindingResult bindingResult, @RequestParam(name="photo")MultipartFile file) throws Exception, IOException {
	  

			if (!(file.isEmpty())) {
				addCust.setLogo(file.getOriginalFilename());
				System.out.println(addCust.getLogo());
			}
			addCust.setStatus("Actif");
			customerrepository.save(addCust);
			System.out.println(addCust.getLogo());

			if (!(file.isEmpty())) {
				
				addCust.setLogo(file.getOriginalFilename());
				System.out.println(addCust.getLogo());

				file.transferTo(new File(images+addCust.getLogo()));
			}
			
			customerrepository.save(addCust);


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
