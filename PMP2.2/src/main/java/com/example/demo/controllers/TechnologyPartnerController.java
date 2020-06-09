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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Customer;
import com.example.demo.entities.RFP;
import com.example.demo.entities.TechnologyPartner;
import com.example.demo.entities.Vendor;
import com.example.demo.repository.TechnologiePartnerRepository;

@Controller
public class TechnologyPartnerController {
	

	@Autowired
	private TechnologiePartnerRepository technologiepartnerRepository;
	
	@Value("${dir.techPartnerFile}")
	private String techPartnerFile;
	
	@RequestMapping(value="/technology")
	public String TechnologyPartner(Model model, TechnologyPartner technologypartne) {
		
		List<TechnologyPartner> technologypartner = technologiepartnerRepository.findAll();
		model.addAttribute("techpart",technologypartner );
		//model.addAttribute("technopart", new TechnologyPartner());
		model.addAttribute("totalTechnologyPartner", technologypartner.size());
		
		List<TechnologyPartner> technPartrActif = technologiepartnerRepository.findByStatus("Actif");
		model.addAttribute("totaltechnPartrActif", technPartrActif.size());
		
		List<TechnologyPartner> technPartrArchived = technologiepartnerRepository.findByStatus("Archived");
		model.addAttribute("totaltechnPartrArchived", technPartrArchived.size());
	
		return "Technology_Partner";
	}
	
	@RequestMapping(value="/SaveTechnologyPartner" , method= RequestMethod.POST)
	private String SaveTechnologyPartner(@Valid TechnologyPartner addTechnologyPart, BindingResult bindingResult, Model model,
			@RequestParam(name="file")MultipartFile file)
					throws IllegalStateException, IOException {
		
		if(technologiepartnerRepository.checkTitleExist(addTechnologyPart.getNameTechnologyPartner())) {
			
			model.addAttribute("unique", "must be unique");
			return "addTechnologyPartner";
		}
		
		
		if(bindingResult.hasErrors()) {
			return "addTechnologyPartner";
			
		}
		addTechnologyPart.setStatus("Actif");
		if (!(file.isEmpty())) {
			
			addTechnologyPart.setTechnologyPartnerFile((file.getOriginalFilename()));

					file.transferTo(new File(techPartnerFile+file.getOriginalFilename()));
				}
		
		technologiepartnerRepository.save(addTechnologyPart);
		return "redirect:/technology";
		
	}
	@RequestMapping(value ="/addTechnologyPartner")
	public String addTechnologyPartne( Model model, Integer id ) {
		
		 model.addAttribute("technologyPartner",technologiepartnerRepository.findAll());
		 model.addAttribute("technologyPartner", new TechnologyPartner());
		
			return "addTechnologyPartner";
			
	}
	
	@RequestMapping(value = "/editTechnologyPartner",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateTechnologyPartner(Model model, @Valid TechnologyPartner technologypart, BindingResult bindingResult,
			@RequestParam(name="file")MultipartFile file) throws IllegalStateException, IOException{
		
		  if(technologiepartnerRepository.checkTitleExist(technologypart.getNameTechnologyPartner())) {
			  
			  	List<TechnologyPartner> technologypartnerDouble = technologiepartnerRepository.searchByName(technologypart.getNameTechnologyPartner());
		  		if(technologypart.getTechnologyPartner_ID().equals(technologypartnerDouble.get(0).getTechnologyPartner_ID())) {
		  			System.out.println("edited name is the same old name");
		  			
		  		}else {
		  			
		  		    TechnologyPartner	technologypartner = technologiepartnerRepository.getOne(technologypart.getTechnologyPartner_ID());
		  			model.addAttribute("techpar",technologypartner);
		  			
		  			model.addAttribute("unique", "must be unique");
					return "updateTechnPartnForm";
		  		}
			}
	
		
		     technologypart.setStatus("Actif");
              if (!(file.isEmpty())) {
			
	             technologypart.setTechnologyPartnerFile((file.getOriginalFilename()));

			     file.transferTo(new File(techPartnerFile+file.getOriginalFilename()));
		}

		technologiepartnerRepository.save(technologypart);
		
		return "redirect:/technology";
	}
	
	@RequestMapping(value ="/updateTechnologyPartner")
	public String updateTechnologyPartnerForm( Model model, Integer id ) {
		
		 TechnologyPartner	technologypartner = technologiepartnerRepository.getOne(id);
		 model.addAttribute("techpar",technologypartner);
		 
		
			return "updateTechnPartnForm";
			
	}
	
	@RequestMapping(value ="/archiverTechnologyPartner" )
	private String archiverTechnologyPartner( Model model, Integer id ) {
	
		TechnologyPartner technologypartner = technologiepartnerRepository.getOne(id);
		technologypartner.setStatus("Archived");
		technologiepartnerRepository.save(technologypartner);
	    System.out.println(technologypartner.getStatus());
		
			return "redirect:/technology";	
			
	}
	
	@RequestMapping(value ="/detailTechnologyPartner")
	public String detailTechnologyPartner( Model model, Integer id ) {
		
		 TechnologyPartner	technologypartner = technologiepartnerRepository.getOne(id);
		 model.addAttribute("technolgpartn",technologypartner);
		
			return "detailTechnologyPartner";
			
	}
	
	@RequestMapping(value="/techPartnerFile/{fileName}")
	@ResponseBody
	public void getdeliveryCertificate(@PathVariable("fileName")String fileName, HttpServletResponse response) {
		
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
			FileInputStream fis = new FileInputStream(techPartnerFile+fileName);
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