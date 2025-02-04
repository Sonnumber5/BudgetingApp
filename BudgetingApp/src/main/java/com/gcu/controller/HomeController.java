package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.business.ExpensesBusinessInterface;

@Controller
public class HomeController {

	@Autowired
	ExpensesBusinessInterface expensesBusinessInterface;
	
	//receives a POST request, and returns to the home screen
    @GetMapping("/home")
    public String showHomePage(Model model) {
    	double addExpenses = expensesBusinessInterface.calculateTotalExpenses();
    	
        model.addAttribute("title", "Home Page");  
        model.addAttribute("addExpenses", addExpenses);
        return "home";  
    }
}