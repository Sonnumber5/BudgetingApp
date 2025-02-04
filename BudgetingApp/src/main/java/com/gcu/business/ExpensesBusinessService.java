package com.gcu.business;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ExpenseDataService;
import com.gcu.data.entities.ExpenseEntity;

//main business logic for the expenses
public class ExpensesBusinessService implements ExpensesBusinessInterface {

	@Autowired
	private ExpenseDataService expenseDataService;
	
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
	public void init() {
		System.out.println("init test from ExpensesBusinessService");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy test from ExpensesBusinessService");
	}
}
