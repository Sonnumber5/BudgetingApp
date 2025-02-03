package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.business.SecurityBusinessService;
import com.gcu.model.RegisterModel;

import jakarta.validation.Valid;

@Controller
public class RegisterController {

	//autowire the SecurityBusinessService business class to this controller
    @Autowired
    private SecurityBusinessService security; 

    //handles the GET request for the register form
    @GetMapping("/register")
    public String displayRegisterForm(Model model) {
        model.addAttribute("title", "Register Form");
        model.addAttribute("registerModel", new RegisterModel());
        return "register"; //Returns the register.html view
    }

    // handles the POST request when the user submits the register form 
    @PostMapping("/register")
    public String register(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
        // if there are errors, return the register page 
    	if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Register Form");
            return "register";
        }
        
        System.out.println("Registration successful for user: " + registerModel.getUsername());

        //redirest the user to the login page after successfully registered 
        return "redirect:/login";
    }
}
