package com.example.demo.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.AssetType;
import com.example.demo.entities.Frimware;
import com.example.demo.entities.Purchasing;
import com.example.demo.entities.RFP;
import com.example.demo.entities.Users;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RFPRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class RFPController {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RFPRepository rfpRepository;
	@Autowired
	private UserRepository userRepository;

	@Value("${dir.RFP}")
	private String rfpFile;
	
	@RequestMapping(value = "/RFP")
	public String AllRFP(Model model , Authentication auth) {
		
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
		List<RFP> rf = rfpRepository.findAll();
		model.addAttribute("rfp", rf);
		model.addAttribute("rf", new RFP());
		
		
		List<RFP> rfpNew = rfpRepository.findByStatusRFP("New");
		model.addAttribute("totalRFPNew", rfpNew.size());
		
		List<RFP> rfpSubmited = rfpRepository.findByStatusRFP("Submited");
		model.addAttribute("totalRFPSubmited", rfpSubmited.size());
		
		List<RFP> rfpWon = rfpRepository.findByStatusRFP("Won");
		model.addAttribute("totalRFPWon", rfpWon.size());
		
		List<RFP> rfpLost = rfpRepository.findByStatusRFP("Lost");
		model.addAttribute("totalRFPLost", rfpLost.size());
		
		List<RFP> rfpArchived = rfpRepository.findByStatusRFP("Archived");
		model.addAttribute("totalRFPArchived", rfpArchived.size());
		
		//Afficher la liste déroulante pour récupérer la liste des customers
		model.addAttribute("customer", customerRepository.findAll());
		model.addAttribute("totalRFP", rf.size());
		return "RFP";
	}
	
	
	@RequestMapping(value="/SaveRFP" , method= RequestMethod.POST)
	private String SaveRFP(@Valid @ModelAttribute("RFP") RFP addRfp, BindingResult bindingResult, 
			@RequestParam(name="request")MultipartFile requestFile, Model model,
			@RequestParam(name="response") MultipartFile responseFile  ) throws IllegalStateException, IOException {
	
		if(rfpRepository.checkTitleExist(addRfp.getTitle())) {
			
			model.addAttribute("unique", "must be unique");
			 model.addAttribute("customer", customerRepository.findAll());	

			return "addRfp";
		}
		if(bindingResult.hasErrors()) {
			 model.addAttribute("customer", customerRepository.findAll());	

			return "addRfp";
		}
		addRfp.setStatusRFP("New");
	
if (!(requestFile.isEmpty())) {
			
			addRfp.setRequestFile((requestFile.getOriginalFilename()));

			requestFile.transferTo(new File(rfpFile+requestFile.getOriginalFilename()));
		}

if (!(responseFile.isEmpty())) {
	
	addRfp.setResponseFile((responseFile.getOriginalFilename()));

	responseFile.transferTo(new File(rfpFile+responseFile.getOriginalFilename()));
}
	rfpRepository.save(addRfp);
		return "redirect:/RFP";
		}
	
	
	@RequestMapping(value ="/addRFP")
	public String addRFP( Model model ) {
		 
		 model.addAttribute("customer", customerRepository.findAll());	
		 model.addAttribute("RFP", new RFP());
		 
			return "addRfp";
			
	}
	
	
	@RequestMapping(value = "/editRFP",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateRFP(Model model, @Valid RFP RFP, BindingResult bindingResult,@RequestParam(name="response") MultipartFile responseFile, @RequestParam(name="request")MultipartFile requestFile) throws IllegalStateException, IOException{
		
if(rfpRepository.checkTitleExist(RFP.getTitle())) {
			
			model.addAttribute("unique", "must be unique");
			 model.addAttribute("customer", customerRepository.findAll());	

			return "updateRFPForm";
		}
		
		
if (!(requestFile.isEmpty())) {
			
			RFP.setRequestFile((requestFile.getOriginalFilename()));

			requestFile.transferTo(new File(rfpFile+requestFile.getOriginalFilename()));
		}

if (!(responseFile.isEmpty())) {
	
	RFP.setResponseFile((responseFile.getOriginalFilename()));

	responseFile.transferTo(new File(rfpFile+responseFile.getOriginalFilename()));
}

		rfpRepository.save(RFP);
		
		return "redirect:/RFP";
	}
	
	@RequestMapping(value ="/updateRFP")
	public String updateRFPForm( Model model, Integer id ) {
		
		 RFP	rfp = rfpRepository.getOne(id);
		 model.addAttribute("RFP",rfp);
		 
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
	
	@RequestMapping(value ="/newRFP" )
	private String newRFP( Model model, Integer id ) {
	
		RFP rfp = rfpRepository.getOne(id);
		rfp.setStatusRFP("New");
		rfpRepository.save(rfp);
	    System.out.println(rfp.getStatusRFP());
	    
	    
			return "redirect:/RFP";	
			
	}
	
	@RequestMapping(value ="/submitedRFP" )
	private String submitedRFP( Model model, Integer id ) {
	
		RFP rfp = rfpRepository.getOne(id);
		rfp.setStatusRFP("Submited");
		rfpRepository.save(rfp);
	    System.out.println(rfp.getStatusRFP());
		
			return "redirect:/RFP";	
			
	}
	
	@RequestMapping(value ="/wonRFP" )
	private String wonRFP( Model model, Integer id ) {
	
		RFP rfp = rfpRepository.getOne(id);
		rfp.setStatusRFP("Won");
		rfpRepository.save(rfp);
	    System.out.println(rfp.getStatusRFP());
		
			return "redirect:/RFP";	
			
	}
	
	@RequestMapping(value ="/lostRFP" )
	private String lostRFP( Model model, Integer id ) {
	
		RFP rfp = rfpRepository.getOne(id);
		rfp.setStatusRFP("Lost");
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
	
	@RequestMapping(value="/rfpfile/{fileName}")
	@ResponseBody
	public void getFileContrat(@PathVariable("fileName")String fileName, HttpServletResponse response) {
		
		if (fileName.indexOf(".doc")>-1) response.setContentType("application/msword");
		if (fileName.indexOf(".docx")>-1) response.setContentType("application/msword");
		if (fileName.indexOf(".xls")>-1) response.setContentType("application/vnd.ms-excel");
		if (fileName.indexOf(".csv")>-1) response.setContentType("application/vnd.ms-excel");
		if (fileName.indexOf(".ppt")>-1) response.setContentType("application/ppt");
		if (fileName.indexOf(".pdf")>-1) response.setContentType("application/pdf");
		if (fileName.indexOf(".zip")>-1) response.setContentType("application/zip");

		response.setHeader("Content-Disposition","attachment; filename=" +fileName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis = new FileInputStream(rfpFile+fileName);
			int len; 
			byte[] buf = new byte[1024];
			while ((len = fis.read(buf)) >0) {
				bos.write(buf,0,len);
			}
			bos.close();
			response.flushBuffer();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	}


