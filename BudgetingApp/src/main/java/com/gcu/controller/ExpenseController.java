package com.gcu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gcu.business.ExpensesBusinessInterface;
import com.gcu.data.ExpenseDataService;
import com.gcu.data.entities.ExpenseEntity;
import com.gcu.model.ExpenseModel;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("categories")
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
    
    @PostMapping("/expense/add")
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
    
    @PostMapping("expense/delete")
    public String deleteExpense(Model model, @RequestParam("expenseId") int id) {
    	dataService.delete(id);
    	List<ExpenseEntity> expenses = dataService.findAll();
    	
    	model.addAttribute("expenses", expenses);
    	return "redirect:/expenses";
    }
    
    @PostMapping("/expense/update")
    public String showExpenseUpdateView(@RequestParam("expenseId") int id, Model model, HttpSession session) {
    	ExpenseEntity expenseToUpdate = dataService.findById(id);

    	List<ExpenseEntity> totalExpenses = expensesBusinessInterface.descByDate();
    	List<List<ExpenseEntity>> categories = expensesBusinessInterface.categorizeExpenses(totalExpenses);
    	
    	model.addAttribute("title", "Update Expense");
    	model.addAttribute("expenseToUpdate", expenseToUpdate);
    	model.addAttribute("categories", categories);
    	return "expense-update";
    }
    
    @PostMapping("expense/update/confirm")
    public String confirmUpdateExpense(@RequestParam("expenseId") int id, @RequestParam String description, @RequestParam double amount, @RequestParam String category, @RequestParam String newCategory, @RequestParam@DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam String notes) {
    	ExpenseEntity expenseToUpdate = dataService.findById(id);
    	if (newCategory != null && newCategory != "") {
    		category = newCategory;
    	}
    	
    	expenseToUpdate.setDescription(description);
    	expenseToUpdate.setAmount(amount);
    	if (category != null && newCategory != null) {
    		expenseToUpdate.setCategory(category);
    	}
    	expenseToUpdate.setDate(date);
    	expenseToUpdate.setNotes(notes);
    	
    	dataService.update(expenseToUpdate);
    	return "redirect:/expenses";
    }
    
    
}

