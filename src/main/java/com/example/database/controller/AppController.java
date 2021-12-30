package com.example.database.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.database.CustomUserDetails;
import com.example.database.bean.User;
import com.example.database.repository.UserRepository;
import com.example.database.service.CustomUserDetailsService;



@Controller
public class AppController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/")
	public String viewHomePage() {
		
		return "index";
		
	}
	
	@GetMapping("/register")
	public ModelAndView showSignPage() {
		
		return new ModelAndView("signup_form","user",new User());
		
	}
	
	@PostMapping("/registered")
	public String registrationSuccess(@ModelAttribute("user")User user) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repository.save(user);
		return "register_success";
	}
	
	/*
	 * @GetMapping("/login") public String showLoginPage() {
	 * 
	 * return "login"; }
	 */
	
	@GetMapping("list_users")
	public ModelAndView viewUserList(ModelAndView model , Principal principal , Model model1) {
		
		List<User> listUser = repository.findAll();
		model1.addAttribute("username", principal.getName());
		model.addObject("userList", listUser);
		model.setViewName("users");
		return model;
	}
	
	
}
