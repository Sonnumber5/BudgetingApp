package com.gcu.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ExpenseDataService;
import com.gcu.data.entities.ExpenseEntity;
import com.gcu.data.repositories.ExpenseRepository;

//main business logic for the expenses
public class ExpensesBusinessService implements ExpensesBusinessInterface {

	@Autowired
	private ExpenseDataService expenseDataService;
	
	@Autowired ExpenseRepository expenseRepository;
	
	//used too add an expense item to the list
	@Override
    public void addExpense(String description, double amount, String category, Date date, String notes) {
		ExpenseEntity expense = new ExpenseEntity(description, amount, category, date, notes);
		try {
			expenseDataService.create(expense);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public double calculateTotalExpenses() {
		List<ExpenseEntity> expenses = expenseRepository.findAll();
		double total = 0.00;
		for (ExpenseEntity expense : expenses) {
			total += expense.getAmount();
		}
		return total;

	}
	
	@Override
	public void init() {
		System.out.println("init test from ExpensesBusinessService");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy test from ExpensesBusinessService");
	}

	@Override
	public List<List<ExpenseEntity>> categorizeExpenses(List<ExpenseEntity> totalExpenses) {
	    Map<String, List<ExpenseEntity>> bucket = new HashMap<>();
	    
	    /*
	    List<String> defaultCategories = List.of("Rent/Mortgage", "Utilities", "Car/Auto", "Groceries", "Subscriptions", "Childcare", "Home Essentials", "Loans", "Indiscriminate");
	    
	    for (String category : defaultCategories) {
	    	bucket.put(category, new ArrayList<>());
	    }
	    */
	    
	    for (ExpenseEntity expense : totalExpenses) {
	        if (!bucket.containsKey(expense.getCategory())) {
	            bucket.put(expense.getCategory(), new ArrayList<>());
	        }
	        bucket.get(expense.getCategory()).add(expense);
	    }
	    
	    // Sort each category by date (descending order)
	    for (List<ExpenseEntity> categoryExpenses : bucket.values()) {
	        categoryExpenses.sort(Comparator.comparing(ExpenseEntity::getDate).reversed());
	    }

	    List<List<ExpenseEntity>> result = new ArrayList<>();
	    for (List<ExpenseEntity> list : bucket.values()) {
	        result.add(list);
	    }
	    return result;
	}

	@Override
	public List<ExpenseEntity> descByDate() {
		return expenseDataService.findAll().stream().sorted(Comparator.comparing(ExpenseEntity::getDate).reversed()).toList();
	}
}
