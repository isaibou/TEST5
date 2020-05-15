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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.*;

import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RFPRepository;
import com.example.demo.repository.UserRepository;



@Controller
public class ContractController {

	@Autowired
	private RFPRepository rfpRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ContratRepository contratrepository; 
	@Autowired
	private UserRepository userRepository;
	

	@Value("${dir.contrat}")
	private String contratfile;
	
	@RequestMapping(value="/contract_manage")
	public String ContractManage(Model model, Contrat contrat , Authentication auth ) {
		
		Users u =userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		List<Contrat> contra = contratrepository.findAll();
		model.addAttribute("totalContrat", contra.size());
		model.addAttribute("con", contra);
		//model.addAttribute("contrat", new Contrat());
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
if(bindingResult.hasErrors()) {
	return "addContracts";
	
}

		contratrepository.save(addCont);
		return "redirect:/contract_manage";
		
	}
	@RequestMapping(value ="/addContracts")
	public String addContracts( Model model, Integer id ) {
		
		
		 model.addAttribute("contrat",contratrepository.findAll());
		 model.addAttribute("contrat", new Contrat());
		 model.addAttribute("customer", customerRepository.findAll());	
		 model.addAttribute("rfp", rfpRepository.findAll());
		
			return "addContracts";
			
	}
	
	@RequestMapping(value = "/editContrat",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateContrat(Model model, @Valid Contrat con, BindingResult bindingResult, @RequestParam(name="contractFile")MultipartFile file) throws IllegalStateException, IOException{

if (!(file.isEmpty())) {
			
			con.setContractFille((file.getOriginalFilename()));

			file.transferTo(new File(contratfile+file.getOriginalFilename()));
		}
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
	
	
	
	@RequestMapping(value="/contratfile/{fileName}")
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
			FileInputStream fis = new FileInputStream(contratfile+fileName);
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
