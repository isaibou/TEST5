package com.example.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		model.addAttribute("project", listP);
		model.addAttribute("type", listTp);
		return "deliverable_manage";
	}
	
	
	
	@RequestMapping(value="/addDeliverable")
	public String addDelivrable(Model model, Deliverable deli, @RequestParam(name="fileD") MultipartFile fileD , @RequestParam(name="picture") MultipartFile picture) throws IllegalStateException, IOException {
		
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

	
	
	@RequestMapping(value ="/updateDeliverable")
	public String updateReference( Model model, Integer id ) {
		
		Deliverable	del = deliverablerepository.getOne(id);
		 model.addAttribute("del",del);
		 
		 model.addAttribute("project", projectrepository.findAll());	
		
			return "updateDeliverable";
			
	}
	
	
	@RequestMapping(value="/editDeliverable")
	public String editDeliverable(Model model, Deliverable deli, @RequestParam(name="fileD") MultipartFile fileD , @RequestParam(name="picture") MultipartFile picture) throws IllegalStateException, IOException {
		
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

	

}
