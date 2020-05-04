package com.example.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Expenses;

import com.example.demo.entities.Users;
import com.example.demo.repository.ExpensesRepository;

import com.example.demo.repository.TypeExpensesRepository;

import com.example.demo.repository.UserRepository;

@Controller
public class ExpensesController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ExpensesRepository expensesRepository;
	@Autowired
	TypeExpensesRepository typeExpensesRepository;

	DateFormat df = new SimpleDateFormat("yyyy-	MM-dd");
	
	@Value("${dir.receipt}")
		private String receipt;
	
	

	
	
	@RequestMapping(value="/expenses")
	public String AllCustomer(Model model, Customer customer, Authentication auth) {
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
		
	List<Expenses> listExpenses = expensesRepository.findAll();
	
	model.addAttribute("listEx", listExpenses);
		

	//	model.addAttribute("waiting", expensesRepository.findByStatutExpense("Waiting"));
		//model.addAttribute("confirmed", expensesRepository.findByStatutExpense("Confirmed"));
		model.addAttribute("expense", new Expenses());
		model.addAttribute("intEx", listExpenses.size());
		model.addAttribute("typeEx", typeExpensesRepository.findAll());
		
	
		return "expense";
	}

	@RequestMapping(value="/addExpenses")
	public String addInternalRequest( Expenses expense, Authentication  auth, @RequestParam(name="recu")MultipartFile file ) throws IllegalStateException, IOException {
		
		String login = auth.getName();
		Users u =  userRepository.getOne(login);
		expense.setUser(u);
		expense.setSubmittedDate(new Date());
		expense.setStatutExpense("Waiting");
		
		expensesRepository.save(expense);
		if (!(file.isEmpty())) 
		{
			expense.setReceipt((file.getOriginalFilename()));
			file.transferTo(new File(receipt+expense.getExpenses_ID()));
		}
		
		
		return"redirect:/expenses";
	}
	
	
	@RequestMapping(value="/answerExpenses")
	public String answer( Integer  id ) {
		
		Expenses  ex = expensesRepository.getOne(id);
		ex.setStatutExpense("Answered");
		
		expensesRepository.save(ex);
		return"redirect:/expenses";
	}
	
	

	@RequestMapping(value="/confirmExpenses")
	public String confirm( Integer  id ) {
		
		Expenses  ex = expensesRepository.getOne(id);
		ex.setStatutExpense("Confirmed");
		
		
		expensesRepository.save(ex);
		return"redirect:/expenses";
	}
	
	
	
	
	
	@RequestMapping(value="/getExpenses" , produces= MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	private byte[] getExpenses(String id) throws  IOException {
		File f = new File(receipt+id);
		return  IOUtils.toByteArray(new FileInputStream(f));
	}
	
	
	@RequestMapping(value ="/updateExpenses" )
	public String updateExpenses(Integer id , Model model) {
		
		Expenses  ex = expensesRepository.getOne(id);
		model.addAttribute("expense", ex);
		//model.addAttribute("customer", u.getCustomer());
		//model.addAttribute("allRoles", u.getRoles());	
		
	
		return "updateExpenses";
	}
	
	  @RequestMapping(value ="/editExpenses" )
	  public String editExpenses(Integer id , Model model, @RequestParam(name="reject")String reject) {
	
		  Expenses e = expensesRepository.getOne(id);
		  e.setRejectReason(reject);
		  expensesRepository.save(e);
	  
	  return "redirect:/expenses"; }
	 
	
	@RequestMapping(value ="/detailsExpenses" )
	public String detailsExpenses(Integer id , Model model) {
		
		Expenses ex = expensesRepository.getOne(id);
		model.addAttribute("ex", ex);
		
		
	
		return "detailsExpenses";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
