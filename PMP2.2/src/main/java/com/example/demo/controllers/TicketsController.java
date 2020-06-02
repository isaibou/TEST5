package com.example.demo.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Assets;
import com.example.demo.entities.Customer;
import com.example.demo.entities.DataCenter;
import com.example.demo.entities.Expenses;
import com.example.demo.entities.Frimware;
import com.example.demo.entities.Project;
import com.example.demo.entities.RFP;
import com.example.demo.entities.Task;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.Users;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.TypeProjectRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.NotificationMail;

import javassist.expr.NewArray;

@Controller
public class TicketsController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private AssetTypeRepository assetTypeRepository;
	@Autowired
	private AssetRepository assetRepository;
	
	@Value("${dir.solution}")
	String refSolution;
	
	@Value("${dir.logfiles}")
	String refLog;
	
	@Autowired
	NotificationMail notif;
	
	@RequestMapping(value="/tickets_manage")
	public String TicketsManage(Authentication auth, Model model ) {
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		List<Assets> a = assetRepository.findAll();
		model.addAttribute("listAsset", a);
		model.addAttribute("ticket", new Ticket());
		List<Ticket> tickets = ticketRepository.findAll();
		model.addAttribute("tickets", tickets);
		model.addAttribute("totalticket", tickets.size());
		
		List<Ticket> submitted = ticketRepository.findByStatusTicket("Submitted");
		List<Ticket> closed = ticketRepository.findByStatusTicket("Closed");
		List<Ticket> waiting = ticketRepository.findByStatusTicket("Waiting");
		List<Ticket> resolved = ticketRepository.findByStatusTicket("Resolved");
		List<Ticket> archived = ticketRepository.findByStatusTicket("Archived");
		List<Ticket> affected = ticketRepository.findByStatusTicket("Affected");
		List<Ticket> processing = ticketRepository.findByStatusTicket("Processing");
		List<Ticket> allTickets = ticketRepository.findAll();
		
		model.addAttribute("totalsubmitted",submitted.size() );
		model.addAttribute("totalclosed",closed.size() );
		model.addAttribute("totalwaiting",waiting.size() );
		model.addAttribute("totalresolved",resolved.size() );
		model.addAttribute("totalarchived",archived.size() );
		model.addAttribute("totalaffected",affected.size() );
		model.addAttribute("totalprocessing",processing.size() );

		
		model.addAttribute("submitted",submitted );
		model.addAttribute("closed",closed );
		model.addAttribute("waiting",waiting );
		model.addAttribute("resolved",resolved );
		model.addAttribute("archived",archived);
		model.addAttribute("affected",affected );
		model.addAttribute("processing",processing );
		model.addAttribute("allTicket", allTickets);

		return "tickets_manage";
	}

	@RequestMapping(value="/addTicket")
	public String addTicket(Authentication auth, Model model, Ticket ticket ) {
		Users u = userRepository.getOne(auth.getName());
		ticket.setStatusTicket("Submitted");
		ticket.setOpenedDate(new Date());
		ticket.setCustomer(u.getCustomer());
		
		ticketRepository.save(ticket);
		
		return "redirect:/tickets_manage";
	}
	
	@RequestMapping(value ="/addTic" )
	public String addTic(Model model, Authentication auth) {
		model.addAttribute("user", userRepository.findAll());
		model.addAttribute("asset", assetRepository.findAll());
		model.addAttribute("typ", ticketRepository.findAll());
		model.addAttribute("tic", new Ticket());
		return "addTicket";
	}
	
	@RequestMapping(value ="waiting" )
	private String waiting( Model model, Integer id ) {
	
	Ticket	Tic = ticketRepository.getOne(id);
			Tic.setStatusTicket("Waiting");
		ticketRepository.save(Tic);
		return "redirect:/tickets_manage";	
			
	}
	
	@RequestMapping(value ="processing" )
	private String processing( Model model, Integer id ) {
	
	Ticket	Tic = ticketRepository.getOne(id);
			Tic.setStatusTicket("Processing");
		ticketRepository.save(Tic);
		return "redirect:/tickets_manage";	
			
	}
	
	

	@RequestMapping(value ="resolved" )
	private String resolved( Model model, Integer id ) {
	
	Ticket	Tic = ticketRepository.getOne(id);
		
	model.addAttribute("ticket", Tic );
		
		
		return "resolved";	
			
	}
	
	@RequestMapping(value ="resolution" )
	private String resolution( Model model, Integer id , @RequestParam(name="file") MultipartFile file,@RequestParam(name="desc") MultipartFile desc ) throws IllegalStateException, IOException {
	
	Ticket	Tic = ticketRepository.getOne(id);
			Tic.setStatusTicket("Resolved");
		
if (!(file.isEmpty())) {
			
			Tic.setLogFiles((file.getOriginalFilename()));

			file.transferTo(new File(refLog+file.getOriginalFilename()));
		}


if (!(desc.isEmpty())) {
	
	Tic.setSolutionDescription((desc.getOriginalFilename()));

	desc.transferTo(new File(refSolution+file.getOriginalFilename()));
}

Tic.setLastUpdatedate(new Date());
	ticketRepository.save(Tic);
		
		return "redirect:/tickets_manage";	
			
	}
	

	@RequestMapping(value ="closed" )
	private String closed( Model model, Integer id ) {
	
	Ticket	Tic = ticketRepository.getOne(id);
			Tic.setStatusTicket("Closed");
			Tic.setClosedDate(new Date());
		ticketRepository.save(Tic);
		return "redirect:/tickets_manage";	
			
	}
	
	
	@RequestMapping(value ="archived" )
	private String Archived( Model model, Integer id ) {
	
	Ticket	Tic = ticketRepository.getOne(id);
			Tic.setStatusTicket("Archived");
		ticketRepository.save(Tic);
		return "redirect:/tickets_manage";	
			
	}
	
	@RequestMapping(value ="affectTo" )
	private String affectTo( Model model, Integer id ) {
	
	Ticket	Tic = ticketRepository.getOne(id);			
	List<Users> employee = userRepository.findByIsCustomer(false);
	model.addAttribute("ticket", Tic);
	model.addAttribute("employee", employee);
		return "Affected";	
			
	}
	
	@RequestMapping(value ="affected" )
	private String affected( Model model, Integer id, @RequestParam(name="employee") Users employee ) {
	
	Ticket	Tic = ticketRepository.getOne(id);			
	Tic.setUser(employee);
	Tic.setStatusTicket("Affected");
	System.out.println(Tic.getTicket_ID());
	System.out.println(Tic.getStatusTicket());
	ticketRepository.save(Tic);
	try {
		notif.notifTicket(Tic);
	} catch (MailException e) {
		e.printStackTrace();
	}

	
		return "redirect:/tickets_manage";	
			
	}
	
	@RequestMapping(value="/getSolution/{fileName}")
	@ResponseBody
	public void getDescriptionSolution(@PathVariable("fileName")String fileName, HttpServletResponse response) {
		
		if (fileName.indexOf(".doc")>-1) response.setContentType("application/msword");
		if (fileName.indexOf(".docx")>-1) response.setContentType("application/msword");
		if (fileName.indexOf(".xls")>-1) response.setContentType("application/vnd.ms-excel");
		if (fileName.indexOf(".csv")>-1) response.setContentType("application/vnd.ms-excel");
		if (fileName.indexOf(".ppt")>-1) response.setContentType("application/ppt");
		if (fileName.indexOf(".pdf")>-1) response.setContentType("application/pdf");
		if (fileName.indexOf(".zip")>-1) response.setContentType("application/zip");

		response.setHeader("Content-Disposition","attachment; filename=" +fileName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis = new FileInputStream(refSolution+fileName);
			int len; 
			byte[] buf = new byte[1024];
			while ((len = fis.read(buf)) >0) {
				bos.write(buf,0,len);
			}
			bos.close();
			response.flushBuffer();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value="/getLogFile/{fileName}")
	@ResponseBody
	public void getLogFile(@PathVariable("fileName")String fileName, HttpServletResponse response) {
		
		if (fileName.indexOf(".doc")>-1) response.setContentType("application/msword");
		if (fileName.indexOf(".docx")>-1) response.setContentType("application/msword");
		if (fileName.indexOf(".xls")>-1) response.setContentType("application/vnd.ms-excel");
		if (fileName.indexOf(".csv")>-1) response.setContentType("application/vnd.ms-excel");
		if (fileName.indexOf(".ppt")>-1) response.setContentType("application/ppt");
		if (fileName.indexOf(".pdf")>-1) response.setContentType("application/pdf");
		if (fileName.indexOf(".zip")>-1) response.setContentType("application/zip");

		response.setHeader("Content-Disposition","attachment; filename=" +fileName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis = new FileInputStream(refLog+fileName);
			int len; 
			byte[] buf = new byte[1024];
			while ((len = fis.read(buf)) >0) {
				bos.write(buf,0,len);
			}
			bos.close();
			response.flushBuffer();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value ="/detailTicketS")
	public String detailS( Model model, Integer id ) {	
		 Ticket ticket = ticketRepository.getOne(id);
		 model.addAttribute("ticket",ticket);
		 model.addAttribute("assettype", assetTypeRepository.findAll());
		
			return "detailTicketS";
			
	}
	
	@RequestMapping(value ="/detailTicketA")
	public String detailA( Model model, Integer id ) {	
		 Ticket ticket = ticketRepository.getOne(id);
		 model.addAttribute("ticke",ticket);
		 model.addAttribute("assettype", assetTypeRepository.findAll());
		
			return "detailTicketA";
			
	}
	
	@RequestMapping(value ="/detailTicketP")
	public String detailP( Model model, Integer id ) {	
		 Ticket ticket = ticketRepository.getOne(id);
		 model.addAttribute("tick",ticket);
		 model.addAttribute("assettype", assetTypeRepository.findAll());
		
			return "detailTicketP";
			
	}
	
	@RequestMapping(value ="/detailTicketW")
	public String detailW( Model model, Integer id ) {	
		 Ticket ticket = ticketRepository.getOne(id);
		 model.addAttribute("tic",ticket);
		 model.addAttribute("assettype", assetTypeRepository.findAll());
		
			return "detailTicketW";
			
	}
	
	@RequestMapping(value ="/detailTicketR")
	public String detailR( Model model, Integer id ) {	
		 Ticket ticket = ticketRepository.getOne(id);
		 model.addAttribute("ti",ticket);
		 model.addAttribute("assettype", assetTypeRepository.findAll());
		
			return "detailTicketR";
			
	}
	
	@RequestMapping(value ="/detailTicketC")
	public String detailC( Model model, Integer id ) {	
		 Ticket ticket = ticketRepository.getOne(id);
		 model.addAttribute("tck",ticket);
		 model.addAttribute("assettype", assetTypeRepository.findAll());
		
			return "detailTicketC";
			
	}
	
	@RequestMapping(value ="/detailTicketAr")
	public String detailAr( Model model, Integer id ) {	
		 Ticket ticket = ticketRepository.getOne(id);
		 model.addAttribute("tkt",ticket);
		 model.addAttribute("assettype", assetTypeRepository.findAll());
		
			return "detailTicketAr";
			
	}
}
