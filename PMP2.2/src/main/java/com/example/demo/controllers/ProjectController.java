package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {
	
	@RequestMapping(value="/projects_manage")
	public String ProjectManage() {
		return "projects_manage";
	}

}
