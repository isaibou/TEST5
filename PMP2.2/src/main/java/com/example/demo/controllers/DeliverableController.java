package com.example.demo.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.*;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DeliverableRepository;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.TypeDeliverableRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class DeliverableController {
	
	@Autowired
	private DeliverableRepository deliverablerepository; 
	@Autowired
	private UserRepository userRepository;
	@Value("${dir.deliverableFile}")
	private String refFile;
	@Value("${dir.deliverablePicture}")
	private String refPicture;
	@Autowired
	private ProjetRepository projectrepository;
	@Autowired
	private TypeDeliverableRepository typeDeliverableRepository;
	
	@RequestMapping(value="/deliverable")
	public String DelivrableManage(Model model, Authentication auth) {
		
		Users u = userRepository.getOne(auth.getName());
		List<TypeDeliverable> listTp = typeDeliverableRepository.findAll();
		List<Project> listP = projectrepository.findAll();
		List<Deliverable> delive = deliverablerepository.findAll();
		model.addAttribute("user", u);
		model.addAttribute("listD", delive);
		model.addAttribute("deliverable", new  Deliverable());
		model.addAttribute("totalDeliverable", delive.size());
		model.addAttribute("project", listP);
		model.addAttribute("type", listTp);
		return "deliverable_manage";
	}
	
	@RequestMapping(value="/addDeliverable")
	public String addDelivrable(@Valid @ModelAttribute("deliv") Deliverable deli, BindingResult bindingResult, Model model,
			@RequestParam(name="fileD") MultipartFile fileD , @RequestParam(name="picture") MultipartFile picture)
					throws IllegalStateException, IOException {
		
		if(deliverablerepository.checkTitleExist(deli.getName())) {
			
		 model.addAttribute("type", typeDeliverableRepository.findAll());
		 model.addAttribute("project", projectrepository.findAll());	
			
			model.addAttribute("unique", "must be unique");
			return "addDelivP";
		}
	
		if(bindingResult.hasErrors()) {
			model.addAttribute("type", typeDeliverableRepository.findAll());
			 model.addAttribute("project", projectrepository.findAll());	
			return "addDelivP";
		}

if (!(fileD.isEmpty())) {
			
			deli.setFile((fileD.getOriginalFilename()));

			fileD.transferTo(new File(refFile+fileD.getOriginalFilename()));
		}
deliverablerepository.save(deli);
if (!(picture.isEmpty())) {
	
	deli.setPreviewFile((picture.getOriginalFilename()));

	picture.transferTo(new File(refPicture+deli.getDeliverable_ID()));
}

deliverablerepository.save(deli);
		
		return "redirect:/deliverable";
	}

	@RequestMapping(value="/getDeliverableFile" , produces= MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	private byte[] getDeliverable(String id) throws  IOException {
		File f = new File(refPicture+id);
		return  IOUtils.toByteArray(new FileInputStream(f));
	}
	
	@RequestMapping(value ="/addDeliv")
	public String addDeliv( Model model) {

		 model.addAttribute("deliv",new Deliverable());
		 model.addAttribute("type", typeDeliverableRepository.findAll());
		 model.addAttribute("project", projectrepository.findAll());	
			return "addDelivP";	
	}

	@RequestMapping(value ="/updateDeliverable")
	public String updateReference( Model model, Integer id ) {
		Deliverable	del = deliverablerepository.getOne(id);
		 model.addAttribute("del",del);
		 model.addAttribute("type", typeDeliverableRepository.findAll());
		 model.addAttribute("project", projectrepository.findAll());	
			return "updateDeliverable";	
	}

	@RequestMapping(value="/editDeliverable")
	public String editDeliverable(Model model, @ModelAttribute("del") Deliverable deli, @RequestParam(name="fileD") MultipartFile fileD ,BindingResult bindingResult,
			@RequestParam(name="picture") MultipartFile picture) throws IllegalStateException, IOException {
		
		if(deliverablerepository.checkTitleExist(deli.getName())) {
			
			 model.addAttribute("type", typeDeliverableRepository.findAll());
			 model.addAttribute("project", projectrepository.findAll());	
				
				model.addAttribute("unique", "must be unique");
				return "updateDeliverable";
			}
		
if (!(fileD.isEmpty())) {
			
			deli.setFile((fileD.getOriginalFilename()));

			fileD.transferTo(new File(refFile+fileD.getOriginalFilename()));
		}

if (!(picture.isEmpty())) {
	
	deli.setPreviewFile((picture.getOriginalFilename()));

	picture.transferTo(new File(refPicture+deli.getDeliverable_ID()));
}

deliverablerepository.save(deli);
		
		return "redirect:/deliverable";

	}	
	
	@RequestMapping(value ="/detailDeliverable")
	public String detailDeliverable( Model model, Integer id ) {
		
		 Deliverable	deliv = deliverablerepository.getOne(id);
		 model.addAttribute("deliverable",deliv);
		 
		 model.addAttribute("typeD", deliv.getTypeDeliverable());
		 
		 System.out.println(deliv.getName());
			return "detaildeliv";
			
	}

@RequestMapping(value="/DeliverableFile/{fileName}")
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
		FileInputStream fis = new FileInputStream(refFile+fileName);
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