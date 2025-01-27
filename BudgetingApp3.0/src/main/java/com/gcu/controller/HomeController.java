package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	//receives a POST request, and returns to the home screen
    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("title", "Home Page");  
        return "home";  
    }
}
