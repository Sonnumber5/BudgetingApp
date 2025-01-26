package com.gcu.business;

import java.util.List;

import com.gcu.model.ExpenseModel;

public interface ExpensesBusinessInterface {
	
	public void test();
	public List<ExpenseModel> getExpenses();
	public void init();
	public void destroy();
	public void addExpense(String description, double amount, String category);
}
