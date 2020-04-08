package com.example.demo.controllers;

import java.util.Collection;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Roles;
import com.example.demo.entities.Users;
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
	
	@RequestMapping(value="/users")
	public String allUser( Model model) {
		
		List<Users> users = userRepository.findAll();
	model.addAttribute("users",users);
	model.addAttribute("addUser",new Users());
		
		
		return "users";
	}
	
	@RequestMapping(value ="/saveUsers")
	public String addUsers(Users u, String role ) {
		String pass=  u.getPassword();
		u.setPassword(encoder.encode(pass));
		//String role = "manager";
		//Roles r = roleRepository.getOne(role);
		//u.getRoles().add(r);
		u.setActived(true);
		userRepository.save(u);
		
		return "redirect:/users";
	}

}
