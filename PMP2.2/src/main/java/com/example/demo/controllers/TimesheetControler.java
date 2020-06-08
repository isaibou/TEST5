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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.AffectationProject;
import com.example.demo.entities.Project;
import com.example.demo.entities.ProjectTask;
import com.example.demo.entities.ProjectUser;
import com.example.demo.entities.Task;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.TypeProject;
import com.example.demo.entities.Users;
import com.example.demo.repository.AffectationProjectRepository;
import com.example.demo.repository.ProjectTaskRepository;
import com.example.demo.repository.ProjectUserrepository;
import com.example.demo.repository.ProjetRepository;
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
	@Autowired
	private ProjectUserrepository projUserRepository;
	@Autowired
	private ProjetRepository projectRepository;
	@Autowired
	private AffectationProjectRepository affRepository;
	
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
		List<Ticket> ticketsAffected = ticketRepository.findByStatusAndUser("Affected", u);
		List<Ticket> ticketsProcessing = ticketRepository.findByStatusAndUser("Processing", u);
		List<Ticket> ticketWaiting = ticketRepository.findByStatusAndUser("Waiting", u);
		List<Ticket> ticketResolved = ticketRepository.findByStatusAndUser("Resolved", u);
		
		List<Ticket> allTickets = new ArrayList<>();
		allTickets.addAll(ticketsAffected);
		allTickets.addAll(ticketsProcessing);
		allTickets.addAll(ticketWaiting);
		
		
		model.addAttribute("tickets",  allTickets);
		model.addAttribute("task", new Task());
		return "addTaskTicket";
	}
	
	
	  @RequestMapping(value ="/addTaskProject", method = RequestMethod.GET )
	  public String addTaskProject(Model model , Authentication auth) { 
		  String name = auth.getName(); 
		  Users u = userRepository.getOne(name); 
	 
	  List<ProjectUser> projUser = projUserRepository.findByUser(u);
	  System.out.println(projUser);
	  List<Project> projet = new ArrayList<>();
	  
	  for (ProjectUser pU : projUser) {
		Project project = pU.getProject();
		System.out.println("prpject pris "+project +"" +project.getStatus());
		String status = project.getStatus(); 
		
		if (status.equalsIgnoreCase("Actif")) {
			projet.add(project);
			System.out.println("lsi----------------------------------------------------------------------------------"+projet);
		}
		  
	}
	  
	  
		/*
		 * for (ProjectUser proj : projUser) { Project projet= proj.getProject();
		 * List<Project> listProject = new ArrayList<>(); listProject.add(projet);
		 */
	   model.addAttribute("project", projet ); 
	   System.out.println("la liste des projest qui doivent etre affichés "+ projet);
	  model.addAttribute("task",  new Task());
	  return "addTaskProject";
		
	}
	  
	
	  
	 
	
	@RequestMapping(value ="/saveTaskTicket", method = RequestMethod.POST )
	public String saveTaskticket(Task task, Authentication auth) {
		Users u = userRepository.getOne(auth.getName());
		task.setUsers(u);
		if (task.getTicket().getStatusTicket().equalsIgnoreCase("Affected")) {
			task.getTicket().setStatusTicket("Processing");
		}
		task.setDateTime(new Date());
		taskRepository.save(task);
		return "redirect:/timesheets";
	}
	
	
	@RequestMapping(value ="/nextTaskProject", method = RequestMethod.POST )
	public String saveTaskProject(Task task,Model model, Authentication auth, @RequestParam(name="proj")Integer id  ) {
		String  username =  auth.getName();
		Users u = userRepository.getOne(username);
		Project proj = projectRepository.getOne(id);
		AffectationProject aff = new AffectationProject();
		aff.setProject(proj);
		aff.setUser(u);
		TypeProject type = proj.getTypeProject();
		Collection<ProjectTask> listPT = type.getProjectTask();
		affRepository.save(aff);
		model.addAttribute("listPT", listPT);
		model.addAttribute("task", new Task());
		model.addAttribute("affectProj", aff);
		return "addTaskProjectNext";
	}
	
	

	@RequestMapping(value ="/saveTaskProject", method = RequestMethod.POST )
	public String saveTaskProject(Task task, @RequestParam(name = "projTask") Integer id, Authentication auth , @RequestParam(name ="affectProj") Integer affectationId) {
		Users u = userRepository.getOne(auth.getName());
		task.setUsers(u);
		taskRepository.save(task);
		ProjectTask projectTAsk = projectTaskRepository.getOne(id);
		System.out.println(projectTAsk);
		AffectationProject aff = affRepository.getOne(affectationId);
		aff.setProjATsk(projectTAsk);
		return "redirect:/timesheets";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
