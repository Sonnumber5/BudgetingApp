package com.gcu.controller;

import java.util.List;

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
import com.gcu.model.ExpenseModel;

@Controller
public class ExpenseController {

    @Autowired
    private ExpensesBusinessInterface expensesBusinessInterface;
    
    @Autowired
    private ExpenseDataService dataService;

    @GetMapping("/expenses")
    public String showExpensesView(Model model) {
    	List<ExpenseEntity> totalExpenses = expensesBusinessInterface.descByDate();
    	List<List<ExpenseEntity>> categories = expensesBusinessInterface.categorizeExpenses(totalExpenses);
    	
        model.addAttribute("title", "My Expenses");  
        model.addAttribute("categories", categories);

        return "expenses";
    }
    
    @PostMapping("/addExpense")
    public String addExpense(@ModelAttribute ExpenseModel expense, Model model, @RequestParam(required = false) String newCategory) {
    	if (newCategory != null && !newCategory.isEmpty()) {
            expense.setCategory(newCategory);
        }
    	if (expense.getCategory() == null) {
    		expense.setCategory("Default Category");
    	}
    		expensesBusinessInterface.addExpense(expense.getDescription(), expense.getAmount(), expense.getCategory(), expense.getDate(), expense.getNotes());
    	
        return "redirect:/expenses";
    }
    
    @PostMapping("deleteExpense")
    public String deleteExpense(Model model, @RequestParam("expenseId") int id) {
    	dataService.delete(id);
    	List<ExpenseEntity> expenses = dataService.findAll();
    	
    	model.addAttribute("expenses", expenses);
    	return "redirect:/expenses";
    }
    
}

