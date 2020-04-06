package com.example.demo.controllers;

import java.util.List;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Users;
import com.example.demo.repository.UsersRepository;

import javassist.expr.NewArray;

@Controller
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@RequestMapping(value="/admin/users")
	public String Users (Model model) {
		
			
			List<Users> users = usersRepository.findAll();
			model.addAttribute("users", users);
			model.addAttribute("addUser", new Users());
			

			return "users";
		
	}
		
		@RequestMapping(value="/SaveUser" , method= RequestMethod.POST)
		private String SaveUser(@Valid Users employee, BindingResult bindingResult) {
			
			employee.setActived(true);
		
			usersRepository.save(employee);
			return "redirect:/users";

	}
		
		

		@RequestMapping(value ="/desactiverUser" )
		private String desactiverUser( Model model, Integer id ) {
		
		Users emp = usersRepository.getOne(id);
		emp.setActived(false);
		
		usersRepository.save(emp);
		
			
				return "redirect:/users";	}
}
