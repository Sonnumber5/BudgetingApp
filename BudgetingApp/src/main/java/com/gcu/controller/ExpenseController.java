package com.gcu.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ExpensesBusinessInterface;
import com.gcu.data.ExpenseDataService;
import com.gcu.data.entities.ExpenseEntity;
import com.gcu.data.repositories.ExpenseRepository;
import com.gcu.model.ExpenseModel;

@Controller
public class ExpenseController {

    @Autowired
    private ExpensesBusinessInterface expensesBusinessInterface;
    
    @Autowired
    private ExpenseDataService dataService;
    
    @Autowired 
    ExpenseRepository expenseRepository;

    @GetMapping("/expenses")
    public String showExpensePage(Model model) {
    	List<ExpenseEntity> expenses = expenseRepository.findAll();
    	
        model.addAttribute("title", "My Expenses"); 
        model.addAttribute("expenses", expenses); 

        return "expenses";
    }
    
    @PostMapping("/addExpense")
    public String addIncome(@ModelAttribute ExpenseModel expense, Model model) {
    	expensesBusinessInterface.addExpense(expense.getDescription(), expense.getAmount(), expense.getCategory(), expense.getDate(), expense.getNotes());
        return "redirect:/expenses";
    }
    
    @PostMapping("deleteExpense")
    public String deleteIncome(Model model, @RequestParam("expenseId") int id) {
    	dataService.delete(id);
    	List<ExpenseEntity> expenses = dataService.findAll();
    	
    	model.addAttribute("expenses", expenses);
    	return "redirect:/expenses";
    }
    
}

