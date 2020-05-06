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
import com.example.demo.entities.Users;
import com.example.demo.entities.Vendor;
import com.example.demo.repository.ProjectTaskRepository;
import com.example.demo.repository.TechnologiePartnerRepository;
import com.example.demo.repository.UserRepository;


@Controller
public class ProjectTaskController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectTaskRepository projecTaskrepository;
	

	
	
	
	@RequestMapping(value="/projectTask")
	public String TechnologyPartner(Model model, Authentication auth) {
		
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user",u );
		
		List<ProjectTask> listp = projecTaskrepository.findAll();
		model.addAttribute("pTask",new ProjectTask() );
		model.addAttribute("listP", listp);
	
		return "projectTask";
	}
	
	@RequestMapping(value="/SaveProjectTask" , method= RequestMethod.POST)
	private String SaveProjecTask( ProjectTask pt) {
		
		projecTaskrepository.save(pt);
		
		return "redirect:/projectTask";
		
	}
	
	@RequestMapping(value = "/editProjectTask",method = {  RequestMethod.POST })
	public String updateTechnologyPartner(Model model, ProjectTask pt ){
        
		projecTaskrepository.save(pt);
				
		return "redirect:/projectTask";
	}
	
	@RequestMapping(value ="/updateProjecttask")
	public String updateTechnologyPartnerForm( Model model, Integer id ) {
		
		ProjectTask	pt = projecTaskrepository.getOne(id);
		 model.addAttribute("pTask",pt);
		 
		
			return "updateProjectTask";
			
	}
	
	
	
}
