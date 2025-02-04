package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ExpensesBusinessInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")//specifies that the URL for this controller is "/"
public class LoginController {
	
	@Autowired
	private ExpensesBusinessInterface expensesBusinessInterface;
	
	//autowires the SecurityBusinessService to handle the authentication logic
	@Autowired
	private SecurityBusinessService security;
	
	//Handles the GET request for the root URL and redirects to the login.html page
	@GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login"; 
    }
	
	//handles the GET request to display the login form
	@GetMapping("/login")
	public String display(Model model) {
		//adds attributes to the model for passing to the view
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login"; //return the login.html view
	}
	
	//handles the POST request when the user submits the login form 
	@PostMapping("/loginSuccess")
	public String home(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
    	expensesBusinessInterface.calculateTotalExpenses();

		//authenticates the data (null for now)
		security.authenticate(null, null);
		
		boolean isAuthenticated = security.authenticate(loginModel.getUsername(), loginModel.getPassword());
		
		if (isAuthenticated) {
			System.out.println("Authentication successful.");
		}
		else {
			System.out.println("Authentication failed.");
		}
		
		// if there are errors, keep the user on the login page
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		// return the home.html view
		return "redirect:/home";
	}
}
