package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.entities.Project;

import com.example.demo.repository.ProjetRepository;

@Controller
public class ProjectController {
	@Autowired
	private ProjetRepository ProjectRepository;
	
	
	@RequestMapping(value="/projects_manage")
	public String ProjectsManage(Model model) {
			List<Project> projet = ProjectRepository.findAll();
			model.addAttribute("proj",projet);
		return "projects_manage";
	}

	
}
