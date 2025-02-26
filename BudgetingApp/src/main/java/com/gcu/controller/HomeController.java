package com.gcu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.business.ExpenseBusinessInterface;
import com.gcu.business.FundsBusinessInterface;
import com.gcu.business.IncomeBusinessInterface;
import com.gcu.business.UserBusinessInterface;
import com.gcu.model.UserModel;

@Controller
public class HomeController {

	@Autowired
	ExpenseBusinessInterface expensesBusinessInterface;
	
	@Autowired
	IncomeBusinessInterface incomesBusinessInterface;
	
	@Autowired
	FundsBusinessInterface fundsBusinessInterface;
	
	@Autowired
	UserBusinessInterface userBusinessInterface;
	
	//receives a POST request, and returns to the home screen
    @GetMapping("/home")
    public String showHomePage(Model model, HttpSession session) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	int id = Integer.parseInt(authentication.getName());
    	UserModel user = userBusinessInterface.findById(id);
    	
    	double expenses = expensesBusinessInterface.calculateTotalExpenses();
    	double incomes = incomesBusinessInterface.calculateTotalIncomes();
    	double funds = fundsBusinessInterface.calculateTotalFunds();
    	
        model.addAttribute("title", "Home Page");  
        model.addAttribute("expenses", expenses);
        model.addAttribute("incomes", incomes);
        model.addAttribute("funds", funds);
        
        session.setAttribute("username", user.getUsername());
        session.setAttribute("id", id);
        return "home";  
    }
    
    @GetMapping("/")
    public String display()
    {
        return "login";
    }
}