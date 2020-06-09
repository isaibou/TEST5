package com.example.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Roles;
import com.example.demo.entities.Users;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.NotificationMail;

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
	
	@Autowired
	NotificationMail notif;
	
	@Value("${dir.photo}")
	private String images;
	
	@RequestMapping(value="/users")
	public String allUser( Model model , Authentication auth ) {
		 String login =  auth.getName();
		 Users user = userRepository.getOne(login);
			model.addAttribute("user",user);
		List<Users> users = userRepository.findAll();
		List<Users> uC = userRepository.findByIsCustomer(true);
		List<Users> uE = userRepository.findByIsCustomer(false);

		model.addAttribute("uE",uE);
		model.addAttribute("uC",uC);
		
		model.addAttribute("totalCust", uC.size());
		model.addAttribute("totalEmp", uE.size());
		
	model.addAttribute("users",users);
	model.addAttribute("addUser",new Users());
	model.addAttribute("addUserC",new Users());
	model.addAttribute("customer", customerRepository.findAll());
	model.addAttribute("allRoles", roleRepository.findAll());	
	
		return "users";
	}
	
	@RequestMapping(value ="/saveUsers" )
	public String addUsers(@Valid @ModelAttribute("userE") Users u ,BindingResult bindingResult,Model model, @RequestParam(name = "photo") MultipartFile file ) throws Exception, IOException {
		
		
		  if(userRepository.checkTitleExist(u.getUsername())) {
		  
		  model.addAttribute("unique", "must be unique");
		  model.addAttribute("customer", customerRepository.findAll());
		  model.addAttribute("allRoles", roleRepository.findAll()); 
		  return "addUserEmp"; 
		  }
		 
		
		
		  if(bindingResult.hasErrors()) { 
			  model.addAttribute("customer",customerRepository.findAll()); 
			  model.addAttribute("allRoles",roleRepository.findAll());
			  return "addUserEmp"; 
			  }
		 
		
		String pass=  getRandomStr();
		u.setPassword(pass);
		try {
			notif.sendMail(u);
		} catch (Exception e) {
			// TODO: handle exception
		}
		u.setPassword(encoder.encode(pass));
		u.setActived(true);
		u.setIsCustomer(false);
			
		userRepository.save(u);	
		
if (!(file.isEmpty())) {
			
			u.setPicture((file.getOriginalFilename()));

			file.transferTo(new File(images+file.getOriginalFilename()));
		}

userRepository.save(u);	


		return "redirect:/users";
	}
	
	@RequestMapping(value ="/addUserE", method = RequestMethod.GET )
	public String addUserE(Model model) {	
		Users u = new Users();
		model.addAttribute("customer", customerRepository.findAll());
		model.addAttribute("allRoles", roleRepository.findAll());
		model.addAttribute("userE", u);

		return "addUserEmp";
	}
	
	@RequestMapping(value ="/saveUsersC" )
	public String addUsersC(@Valid @ModelAttribute("userC") Users u,BindingResult bindingResult,Model model ) throws Exception, IOException {
		
		
		 if(userRepository.checkTitleExist(u.getUsername())) {
				
				model.addAttribute("unique", "must be unique");
				model.addAttribute("customer", customerRepository.findAll());
				model.addAttribute("allRoles", roleRepository.findAll());	
				return "addUserCust";
			} 
		 
		  if(bindingResult.hasErrors()) { 
			  model.addAttribute("customer",customerRepository.findAll()); 
			  model.addAttribute("allRoles", roleRepository.findAll()); 
			  return "addUserCust"; 
			  }
		 
		
		String pass=  getRandomStr();
		u.setPassword(pass);
		try {
			notif.sendMail(u);
		} catch (Exception e) {
			// TODO: handle exception
		}
		u.setPassword(encoder.encode(pass));
		u.setActived(true);
		u.setIsCustomer(true);
			
		userRepository.save(u);
		return "redirect:/users";
	}
	
	@RequestMapping(value ="/addUserC", method = RequestMethod.GET )
	public String addUserC(Model model) {
		Users u = new Users();
		model.addAttribute("customer", customerRepository.findAll());
		model.addAttribute("allRoles", roleRepository.findAll());
		model.addAttribute("userC", new Users());
		return "addUserCust";
	}
	
	@RequestMapping(value="/getPhoto" , produces= MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	private byte[] getLogo(String id) throws  IOException {
		File f = new File(images+id);
		return  IOUtils.toByteArray(new FileInputStream(f));
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
	
	@RequestMapping(value ="/updateUserform" )
	public String updateUsers(String id , Model model) {
		
		Users u = userRepository.getOne(id);
		model.addAttribute("user", u);
		model.addAttribute("customer", u.getCustomer());
		model.addAttribute("allRoles", u.getRoles());	
		
		return "updateUsers";
	}
	
	@RequestMapping(value ="/updateUserformC" )
	public String updateUsersC(String id , Model model) {
		
		Users u = userRepository.getOne(id);
		model.addAttribute("user", u);
		model.addAttribute("customer", u.getCustomer());
		model.addAttribute("allRoles", u.getRoles());	
		
		return "updateUsersCustomer";
	}
	
	@RequestMapping(value ="/detailsUser" )
	public String detailsUser(String id , Model model) {
		
		Users u = userRepository.getOne(id);
		model.addAttribute("user", u);
		model.addAttribute("customer", u.getCustomer());
		model.addAttribute("roro", u.getRoles());	
		
	
		return "detailsUsers";
	}
	
	@RequestMapping(value ="/detailsUserC" )
	public String detailsUserC(String id , Model model) {
		
		Users u = userRepository.getOne(id);
		model.addAttribute("user", u);
		model.addAttribute("customer", u.getCustomer());
		model.addAttribute("roro", u.getRoles());	
		
	
		return "detailsUsersCustomer";
	}
	

	@RequestMapping(value ="/editUsers" )
	public String editUsers(Users u, Model model,@RequestParam(name = "photo") MultipartFile file) throws IllegalStateException, IOException {
		
        
        
		u.setActived(true);
		u.setIsCustomer(false);
		userRepository.save(u);
		
if (!(file.isEmpty())) {
			
			u.setPicture((file.getOriginalFilename()));

			file.transferTo(new File(images+file.getOriginalFilename()));
		}

userRepository.save(u);

		return "redirect:/users";
	}
	
	@RequestMapping(value ="/editUsersC" )
	public String editUsersC(Users u, Model model) {
	
		u.setIsCustomer(true);
			
		userRepository.save(u);
		return "redirect:/users";
	}


	@RequestMapping(value ="/profile" )
	public String profile(Authentication authentication , Model model) {
		
		String login = authentication.getName();
		Users u = userRepository.getOne(login);
		model.addAttribute("user",u);
		System.out.println(u.getPhone());
		
		return "profile";
	}
	
	
	@RequestMapping(value ="/forgotPassword" )
	public String forgotPassword(Authentication authentication , Model model) {
		
		model.addAttribute("user", new Users());
		return "forgotPassword";
	}
	
	@RequestMapping(value ="/changePassword" )
	public String changePassword(String password ,@RequestParam(name="Phone") String phone, 
			@RequestParam(name="confirm") String confirm,@RequestParam(name="password") String pass, Authentication auth
			,Model model) {
		String login = auth.getName(); 
		System.out.println("confirm " + confirm + " password" + pass + "phone" + phone);
		Users u = userRepository.getOne(login);
		
		if(!confirm.isEmpty()&& !pass.isEmpty()) {
			if (confirm.equals(pass)) {
				u.setPassword(encoder.encode(pass));
			}else { 
				model.addAttribute("user",u);
				model.addAttribute("error", "Password and Confirm Password must be Equal");
				return "profile";	
			}
		}else {
			model.addAttribute("user",u);
			model.addAttribute("error", "Password and Confirm Password must not be Empty");
			return "profile";
		}
		
		u.setPhone(phone);
		userRepository.save(u);
		return "redirect:/profile";
	}
	
	@RequestMapping(value ="/resetPassword" )
	public String resetPassword(String username) {
		Users u = userRepository.getOne(username);
	String pass = getRandomStr();
	u.setPassword(pass);
	u.setActived(true);
	
	try {
		notif.resetPassword(u);
	} catch (Exception e) {
		// TODO: handle exception
	}
	u.setPassword(encoder.encode(pass));
		
		userRepository.save(u);
		return "redirect:/users";
	}
	
	 public static String getRandomStr() 
	    {
	        //choisissez un caractére au hasard à partir de cette chaîne
	        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                    + "abcdefghijklmnopqrstuvxyz" 
	        		+"0123456789"; 
	  
	        StringBuilder s = new StringBuilder(8); 
	  
	        for (int i = 0; i < 8; i++) { 
	            int index = (int)(str.length() * Math.random()); 
	            s.append(str.charAt(index)); 
	        } 
	        return s.toString(); 
	    }
	 
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     if (auth != null){    
	         new SecurityContextLogoutHandler().logout(request, response, auth);
	     }
	     return "redirect:/LoginVrai?logout";
	 }
}