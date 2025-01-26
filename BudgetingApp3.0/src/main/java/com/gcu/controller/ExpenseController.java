package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ExpensesBusinessService;
import com.gcu.business.IncomesBusinessService;
import com.gcu.model.ExpenseModel;
import com.gcu.model.IncomeModel;

@Controller
public class ExpenseController {

    @Autowired
    private ExpensesBusinessService expensesBusinessService;

    @GetMapping("/expenses")
    public String showExpensePage(Model model) {
    	List<ExpenseModel> expenses = expensesBusinessService.getExpenses();

        model.addAttribute("title", "My Expenses"); 
        model.addAttribute("expenses", expenses); 

        return "expenses";
    }
    
    @PostMapping("/addExpense")
    public String addIncome(@RequestParam String description, @RequestParam double amount, @RequestParam String category) {
    	expensesBusinessService.addExpense(description, amount, category);
        return "redirect:/expenses";
    }
    
}

