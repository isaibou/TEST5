package com.example.demo.controllers;

import java.util.Collection;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Roles;
import com.example.demo.entities.Users;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UserRepository userRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping(value="/users")
	public String allUser( Model model) {
		
		List<Users> users = userRepository.findAll();
	model.addAttribute("users",users);
	model.addAttribute("addUser",new Users());
	model.addAttribute("customer", customerRepository.findAll());
	model.addAttribute("allRoles", roleRepository.findAll());	
		
		
		return "users";
	}
	
	@RequestMapping(value ="/saveUsers" )
	public String addUsers(Users u, Model model) {
		String pass=  u.getPassword();
		u.setPassword(encoder.encode(pass));
		u.setActived(true);
		userRepository.save(u);
		return "redirect:/users";
	}

	
	
	@RequestMapping(value ="/editUsers" )
	public String editUsers(Users u, Model model) {
		String pass=  u.getPassword();
		u.setPassword(encoder.encode(pass));
		u.setActived(true);
		userRepository.save(u);
		return "redirect:/users";
	}
	
	@RequestMapping(value ="updateUserform" )
	private String updateUserform( Model model, String id ) {
	Users	user = userRepository.getOne(id);
		 model.addAttribute("user",user);
		 model.addAttribute("customer", customerRepository.findAll());
			model.addAttribute("allRoles", roleRepository.findAll());
		
			return "updateUsers";
			
	}

	
	@RequestMapping(value ="activerUser" )
	private String activerUser( Model model, String id ) {
	
	Users user = userRepository.getOne(id);
	user.setActived(true);
	userRepository.save(user);	
		
	return "redirect:/users";	
			
	}	
	
	@RequestMapping(value ="desactiverUser" )
	private String desactiverUser( Model model, String id ) {
	
	Users user = userRepository.getOne(id);
	user.setActived(false);

userRepository.save(user);	
		
			return "redirect:/users";	
			
	}
	
	@RequestMapping(value ="detailsUser" )
	private String detailsUser( Model model, String id ) {
	
	Users user = userRepository.getOne(id);
	model.addAttribute("user", user);
	user.getCustomer().getName();
	user.getRoles();
	model.addAttribute("roro", user.getRoles());
	model.addAttribute("customer", user.getCustomer());
	
	return "detailsUsers";	
			
	}
	
	@RequestMapping(value="/LoginVrai?logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/LoginVrai?logout";
	}
	
	



	
	
}
