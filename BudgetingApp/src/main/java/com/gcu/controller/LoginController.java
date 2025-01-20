package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.model.User;

import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}	
	
	@PostMapping("/login")
	public String authenticateUser(@RequestParam String userName, @RequestParam String password, Model model) {
		if ("admin".equals(userName) && "password".equals(password)) {
			model.addAttribute("userName", userName);
			return "index";
		}
		else {
			model.addAttribute("error", "Invalid username or password");
		}
		return "login";
	}
}
