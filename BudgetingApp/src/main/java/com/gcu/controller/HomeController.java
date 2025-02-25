package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.business.ExpenseBusinessInterface;
import com.gcu.business.FundsBusinessInterface;
import com.gcu.business.IncomeBusinessInterface;

@Controller
public class HomeController {

	@Autowired
	ExpenseBusinessInterface expensesBusinessInterface;
	
	@Autowired
	IncomeBusinessInterface incomesBusinessInterface;
	
	@Autowired
	FundsBusinessInterface fundsBusinessInterface;
	
	//receives a POST request, and returns to the home screen
    @GetMapping("/home")
    public String showHomePage(Model model) {
    	double expenses = expensesBusinessInterface.calculateTotalExpenses();
    	double incomes = incomesBusinessInterface.calculateTotalIncomes();
    	double funds = fundsBusinessInterface.calculateTotalFunds();
    	
        model.addAttribute("title", "Home Page");  
        model.addAttribute("expenses", expenses);
        model.addAttribute("incomes", incomes);
        model.addAttribute("funds", funds);
        return "home";  
    }
}