package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.*;
import com.example.demo.repository.ProjetRepository;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjetRepository ProjectRepository;

	@RequestMapping(value="/projects_manage")
	public String AllProject(Model model, Project project) {
		
			List<Project> projs = ProjectRepository.findAll();
			model.addAttribute("proj",projs);
			model.addAttribute("project", new Project());
			
		return "projects_manage";
	}

	@RequestMapping(value="/SaveProject" , method= RequestMethod.POST)
	private String SaveProject(@Valid Project addProj, BindingResult bindingResult) {
		
		addProj.setStatus("Actif");
		
		ProjectRepository.save(addProj);
		return "redirect:/projects_manage";
		
	}

	@RequestMapping(value = "/editProject",method= RequestMethod.POST)
	public String updateProject(Model model, Project proj){
		
	  proj= 	(Project) model.getAttribute("project");
		ProjectRepository.save(proj);
		
		return "redirect:/projects_manage";
	}
	
	@RequestMapping(value ="/updateProject")
	public String updateProjectForm( Model model, Integer id ) {
		
	Project	project = ProjectRepository.getOne(id);
		 model.addAttribute("project",project);
		 System.out.println(project.getName());
		
			return "updateProj";
			
	}

	@RequestMapping(value ="/deleteProject" )
	private String deleteProject( Model model, Integer id ) {
	
		ProjectRepository.deleteById(id);
		
			return "redirect:/projects_manage";	
	}

	@RequestMapping(value ="/archiverProject" )
	private String archiverProject( Model model, Integer id ) {
	
	Project proj = ProjectRepository.getOne(id);
	proj.setStatus("Archived");
	proj.setName("Refonte");
	ProjectRepository.save(proj);
	System.out.println(proj.getStatus());
		
			return "redirect:/projects_manage";	
	}
}
