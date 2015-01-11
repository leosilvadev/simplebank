package br.fatea.simplebank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/home")
	public String home(Model model){
		model.addAttribute("message", "Admin Home!");
		return "admin_home";
	}

}
