package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String welcome(Model model){
		model.addAttribute("greeting", "Hamro Autoparts");
		model.addAttribute("tagline", "Your destination for Japanese and American Autoparts");
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
		public String greeting() {
		return "welcome";
	}
}
