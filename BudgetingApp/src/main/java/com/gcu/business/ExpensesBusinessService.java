package com.gcu.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public void addExpense(String description, double amount, String category, LocalDate date, String notes) {
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
}
