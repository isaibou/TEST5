package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Assets;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Expenses;
import com.example.demo.entities.ExternalRequest;
import com.example.demo.entities.InternalRequest;
import com.example.demo.entities.Project;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.Users;
import com.example.demo.entities.Vendor;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ExpensesRepository;
import com.example.demo.repository.ExternalRequestRepository;
import com.example.demo.repository.InternalRequestRepository;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VendorRepository;

@Controller
public class IndexController {

		@Autowired
		private TicketRepository ticketRepository;

		@Autowired
		private AssetRepository assetRepository;
		
		@Autowired
		private CustomerRepository customerrepository;
		
		@Autowired
		private VendorRepository vendorRepository;
		
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private ProjetRepository projectRepository;
		
		@Autowired
		private ExpensesRepository expensesRepository;
		
		@Autowired
		private ExternalRequestRepository externalRequestRepository;
		
		@Autowired
		private InternalRequestRepository internalRequestrepository;
		
		@RequestMapping(value="/index", method = RequestMethod.POST)
		public String Index(Model model, Authentication auth ) {

			List<Assets> asset = assetRepository.findAll();
			model.addAttribute("totalAst",asset.size());
			List<Ticket> submitted = ticketRepository.findByStatusTicket("Submitted");
			model.addAttribute("totalsub",submitted.size());
			List<Ticket> waiting = ticketRepository.findByStatusTicket("Waiting");
			 model.addAttribute("totalwait",waiting.size());
			List<Ticket> resolved = ticketRepository.findByStatusTicket("Resolved");
			model.addAttribute("totalresolv",resolved.size());
			List<Ticket> affected = ticketRepository.findByStatusTicket("Affected");
			model.addAttribute("totalaffect",affected.size());
			List<Ticket> processing = ticketRepository.findByStatusTicket("Processing");
			model.addAttribute("totalprocess",processing.size());
			List<Customer> vip = customerrepository.findByVip("YES");
			model.addAttribute("vipCust", vip.size());
			List<Customer> custs = customerrepository.findAll();
			model.addAttribute("totalCust", custs.size());
			List<Vendor> vendo = vendorRepository.findAll();
			model.addAttribute("totalVndr", vendo.size());
			List<Users> uE = userRepository.findByIsCustomer(false);
			model.addAttribute("totalEmpl", uE.size());
			List<Project> projectActif = projectRepository.findByStatus("Actif");
			model.addAttribute("Activedproj", projectActif.size());			
			List<Project> projectArchived = projectRepository.findByStatus("Archived");
			model.addAttribute("Archivedproj", projectArchived.size());
			List<Expenses> expensesWaiting = expensesRepository.findByStatutExpense("Waiting");
			model.addAttribute("expWait", expensesWaiting.size());
			List<Expenses> expensesAnswered = expensesRepository.findByStatutExpense("Answered");
			model.addAttribute("expAns", expensesAnswered.size());
			List<Expenses> expensesConfirmed = expensesRepository.findByStatutExpense("Confirmed");
			model.addAttribute("expConf", expensesConfirmed.size());
			List<ExternalRequest> extWait = externalRequestRepository.findByStatus(true);
			model.addAttribute("extWait", extWait.size());
			List<ExternalRequest> extAns = externalRequestRepository.findByStatus(true);
			model.addAttribute("extAns", extAns.size());
			List<InternalRequest> intWait = internalRequestrepository.findByStatus("Waiting");
			model.addAttribute("intWait", intWait.size());
			List<InternalRequest> intConf = internalRequestrepository.findByStatus("Confirmed");
			model.addAttribute("intConf", intConf.size());
			List<InternalRequest> intAns = internalRequestrepository.findByStatus("Answered");
			model.addAttribute("intAns", intAns.size());

           return "index";
		}
}

