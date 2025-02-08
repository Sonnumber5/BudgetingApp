package com.gcu.business;

import java.util.Date;
import java.util.List;

import com.gcu.data.entities.ExpenseEntity;

public interface ExpensesBusinessInterface {
	
	//describes the contract between the ExpensesBusinessService class that implements this interface
	public void init();
	public void destroy();
	public void addExpense(String description, double amount, String category, Date date, String notes);
	public double calculateTotalExpenses();
	public List<List<ExpenseEntity>> categorizeExpenses();
	public List<ExpenseEntity> descByDate(List<ExpenseEntity> list); 
}
