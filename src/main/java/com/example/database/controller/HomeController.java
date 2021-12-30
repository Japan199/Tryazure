package com.example.database.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/home")
	public ModelAndView viewHomePage(ModelAndView model , Principal principal , Model model1) {
		
		model1.addAttribute("username", principal.getName());
		model.setViewName("home");
		
		return model;
	}
}	

