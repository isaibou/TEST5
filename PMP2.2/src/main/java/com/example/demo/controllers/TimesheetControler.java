package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.AffectationProject;
import com.example.demo.entities.ProjectTask;
import com.example.demo.entities.Task;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.Users;
import com.example.demo.repository.AffectationProjectRepository;
import com.example.demo.repository.ProjectTaskRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class TimesheetControler {
	
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	@Autowired
	private AffectationProjectRepository afp;
	
	
	@RequestMapping(value="/timesheets")
	public String Timesheet(Model model , Authentication auth) {
		String name =  auth.getName();
		Users u = userRepository.getOne(name);
		
	List<Task> tasks = taskRepository.findAll();	
	List<Task> taskUser = taskRepository.findByUsers(u);
		model.addAttribute("allTask", tasks);
		model.addAttribute("task", taskUser);
		
		
		return "timesheets";
	}
	
	@RequestMapping(value ="/addTaskTicket", method = RequestMethod.GET )
	public String addTaskticket(Model model , Authentication auth) {
		 String name = auth.getName();
		 Users u = userRepository.getOne(name);
		List<Ticket> tickets = ticketRepository.findByUser(u);
		
		model.addAttribute("tickets",  tickets);
		model.addAttribute("task", new Task());
		return "addTaskTicket";
	}
	
	
	  @RequestMapping(value ="/addTaskProject", method = RequestMethod.GET )
	  public String addTaskProject(Model model , Authentication auth) { 
		  String name = auth.getName(); 
		  Users u = userRepository.getOne(name); 
	 
	  Collection<AffectationProject> aff = afp.findByUser(u);	  
	  model.addAttribute("projectTask", aff ); 
	  model.addAttribute("task",  new Task());
	  return "addTaskProject";
	  }
	 
	
	@RequestMapping(value ="/saveTaskTicket", method = RequestMethod.POST )
	public String saveTaskticket(Task task, Authentication auth) {
		Users u = userRepository.getOne(auth.getName());
		task.setUsers(u);
		task.getTicket().setStatusTicket("Processing");
		task.setDateTime(new Date());
		taskRepository.save(task);
		return "redirect:/timesheets";
	}
	
	
	@RequestMapping(value ="/saveTaskProject", method = RequestMethod.POST )
	public String saveTaskProject(Task task, Authentication auth) {
		Users u = userRepository.getOne(auth.getName());
		task.setUsers(u);
		task.setDateTime(new Date());
		taskRepository.save(task);
		return "redirect:/timesheets";
	}
}
