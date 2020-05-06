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

import com.example.demo.entities.ProjectTask;
import com.example.demo.entities.TechnologyPartner;
import com.example.demo.entities.TypeProject;
import com.example.demo.entities.Users;
import com.example.demo.entities.Vendor;
import com.example.demo.repository.ProjectTaskRepository;
import com.example.demo.repository.TechnologiePartnerRepository;
import com.example.demo.repository.TypeProjectRepository;
import com.example.demo.repository.UserRepository;


@Controller
public class TypeProjectController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TypeProjectRepository typeProjectRepository;
	@Autowired
	private ProjectTaskRepository projectTaskrepository;
	
	

	
	
	@RequestMapping(value="/typeProject")
	public String TechnologyPartner(Model model, Authentication auth) {
		
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user",u );
		
		List<TypeProject> listTp = typeProjectRepository.findAll();
		List<ProjectTask> listpt = projectTaskrepository.findAll();
		model.addAttribute("tProject",new TypeProject() );
		model.addAttribute("listTp", listTp);
		model.addAttribute("listpt", listpt);

	
		return "typeProject";
	}
	
	@RequestMapping(value="/SaveTypeProject" , method= RequestMethod.POST)
	private String SaveTypeProject( TypeProject tP) {
		
		typeProjectRepository.save(tP);
		
		return "redirect:/typeProject";
		
	}
	
	@RequestMapping(value = "/editTypeProject",method = {  RequestMethod.POST })
	public String updateTypeProject(Model model, TypeProject tP ){
        
		typeProjectRepository.save(tP);
				
		return "redirect:/typeProject";
	}
	
	@RequestMapping(value ="/updatTypeProject")
	public String updateTechnologyPartnerForm( Model model, Integer id ) {
		
		TypeProject	tP = typeProjectRepository.getOne(id);
		 model.addAttribute("pTask",tP);
		 
		 List<ProjectTask> listpt = projectTaskrepository.findAll();
		 model.addAttribute("listpt", listpt); 
		 
			return "updateTypeProject";
			
	}
	
	@RequestMapping(value ="/detailsTypeProject")
	public String detailsTypeProject( Model model, Integer id ) {
		
		 TypeProject	tP = typeProjectRepository.getOne(id);
		 model.addAttribute("pTask",tP);
		 List<ProjectTask> listpt = projectTaskrepository.findAll();
		 model.addAttribute("listpt", listpt);
		 List<ProjectTask> Pt = (List<ProjectTask>) tP.getProjectTask();
		 model.addAttribute("listPt",Pt );
		 
		
			return "detailsTypeProject";
			
	}
	
	
}
