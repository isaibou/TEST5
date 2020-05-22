package com.example.demo.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Expenses;

import com.example.demo.entities.Task;

import com.example.demo.entities.TypeExpenses;

import com.example.demo.entities.Users;
import com.example.demo.repository.ExpensesRepository;
import com.example.demo.repository.TaskRepository;
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
	@Autowired
	TaskRepository taskRepository;

	DateFormat df = new SimpleDateFormat("yyyy-	MM-dd");
	
	@Value("${dir.receipt}")
		private String receipt;
	
	@RequestMapping(value="/expenses")
	public String AllCustomer(Model model, Authentication auth) {
		Users u = userRepository.getOne(auth.getName());
		model.addAttribute("user", u);
		
	    List<Expenses> listExpenses = expensesRepository.findAll();
	    List<TypeExpenses> listExp = typeExpensesRepository.findAll();
	    
	    model.addAttribute("listEx", listExpenses);
	    model.addAttribute("typeEx", listExp);
		model.addAttribute("expense", new Expenses());
		model.addAttribute("totalExp", listExpenses.size());
		

		return "expense";
	}


	@RequestMapping(value="/SaveExpenses")
	public String addInternalRequest(@Valid Expenses expense,BindingResult bindingResult, Authentication  auth, 
			@RequestParam(name="recu")MultipartFile file ) 
					throws IllegalStateException, IOException {

	

		
		
		String login = auth.getName();
		Users u =  userRepository.getOne(login);
		expense.setUser(u);
		expense.setSubmittedDate(new Date());
		expense.setStatutExpense("Waiting");
		expensesRepository.save(expense);
		if (!(file.isEmpty())) 
		{
			expense.setReceipt((file.getOriginalFilename()));
			file.transferTo(new File(receipt+expense.getReceipt()));
		}
		expensesRepository.save(expense);

		

			

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

	@RequestMapping(value ="/addExp" )
	public String addExp(Model model, Authentication  auth) {

		model.addAttribute("expenses", new Expenses());
		//model.addAttribute("type", typeExpensesRepository.findAll());

	
		  Users u = userRepository.getOne(auth.getName());
		  model.addAttribute("exp",  new Expenses());
		 model.addAttribute("type",  typeExpensesRepository.findAll());
		  
		  
		  List<Task> tasks = taskRepository.findByUsers(u);
		  System.out.println(tasks);
	     model.addAttribute("task",tasks);

		return "addExp";
	}
	
	@RequestMapping(value ="/updateExpenses" )
	public String updateExpenses(Integer id , Model model) {
		
		Expenses  ex = expensesRepository.getOne(id);
		model.addAttribute("expense", ex);
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
	
	
	
	

@RequestMapping(value="/receipt/{fileName}")
@ResponseBody
public void getReceipt(@PathVariable("fileName")String fileName, HttpServletResponse response) {
	
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
		FileInputStream fis = new FileInputStream(receipt+fileName);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
