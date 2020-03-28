package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.*;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProjetRepository;

@Controller
public class ProjectController {
	@Autowired
	private ProjetRepository ProjectRepository;
	
	
	@RequestMapping(value="/projects_manage")
	public String ProjectsManage(Model model) {
		
			List<Project> projet = ProjectRepository.findAll();
			model.addAttribute("proj",projet);
			model.addAttribute("project", new Project());
			
		return "projects_manage";
	}

	@RequestMapping(value="/SaveProject" , method= RequestMethod.POST)
	private String SaveProject(Project proj) {
		ProjectRepository.save(proj);
		return "redirect:/projects_manage";
		
	}
	
	@RequestMapping(value ="/updateProject" )
	private String updateCustomer( Model model, Integer id ) {
	Project	project = ProjectRepository.getOne(id);
		 model.addAttribute("project",project);
		 System.out.println(project.getName());
		
			return "updateProject";
			
	}


	@RequestMapping(value ="/deleteProject" )
	private String deleteProject( Model model, Integer id ) {
	
		ProjectRepository.deleteById(id);
		
			return "redirect:/projects_manage";	
	}
}
