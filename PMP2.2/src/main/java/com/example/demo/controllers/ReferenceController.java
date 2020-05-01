package com.example.demo.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Project;
import com.example.demo.entities.Reference;
import com.example.demo.entities.Users;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.ReferenceRepository;
import com.example.demo.repository.UserRepository;



@Controller
public class ReferenceController {
	
	@Autowired
	private ReferenceRepository referencerepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjetRepository projectRepository;
	@Value("${dir.referenceFile}")
	private String refFile;
	@Value("${dir.referencePicture}")
	private String refPicture;
	

	
	@RequestMapping(value="/reference")
	public String ReferenceManage(Model model, Authentication auth) {
		 
		Users u = userRepository.getOne(auth.getName());
		
		List<Reference> reference = referencerepository.findAll();
		List<Project> project =  projectRepository.findAll();
		model.addAttribute("reference", new Reference());
		model.addAttribute("user", u);
		model.addAttribute("listRef", reference);
		model.addAttribute("project", project);
		return "reference_manage";
	}

	

	@RequestMapping(value="/SaveReference" , method= RequestMethod.POST)
	private String SaveReference(@Valid Reference ref, @RequestParam(name ="file")  MultipartFile file , @RequestParam(name ="picture")  MultipartFile picture,BindingResult bindingResult) throws IllegalStateException, IOException {
		
		

			if (!(file.isEmpty())) {
			
			ref.setReferenceFile((file.getOriginalFilename()));

			file.transferTo(new File(refFile+file.getOriginalFilename()));
		}
			referencerepository.save(ref);


		

		if (!(picture.isEmpty())) {
		
		ref.setPreviewPicture((file.getOriginalFilename()));

		file.transferTo(new File(refPicture+ref.getReference_ID()));
	}

		
		
		return "redirect:/projects";	
	}

	    
	/*
	 * @RequestMapping(value = "/editProject",method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String updateProject(Model model, @Valid Project
	 * proj, BindingResult bindingResult){
	 * 
	 * ProjectRepository.save(proj);
	 * 
	 * return "redirect:/projects"; }
	 * 
	 * @RequestMapping(value ="/updateProject") public String updateProjectForm(
	 * Model model, Integer id ) {
	 * 
	 * Project project = ProjectRepository.getOne(id);
	 * model.addAttribute("project",project);
	 * 
	 * model.addAttribute("TechnologiePartnerRepository",
	 * technologiepartnerRepository.findAll());
	 * 
	 * System.out.println(project.getName());
	 * 
	 * return "updateProj";
	 * 
	 * }
	 * 
	 * @RequestMapping(value ="/detailProject") public String detailProject( Model
	 * model, Integer id ) {
	 * 
	 * Project project = ProjectRepository.getOne(id);
	 * model.addAttribute("project",project); System.out.println(project.getName());
	 * 
	 * return "detailProj";
	 * 
	 * }
	 */

}
