package com.gcu.business;

import java.util.Date;
import java.util.List;

import com.gcu.model.ExpenseModel;

public interface ExpenseBusinessInterface {
	
	//describes the contract between the ExpensesBusinessService class that implements this interface
	public void init();
	public void destroy();
	public void addExpense(String description, double amount, String category, Date date, String notes);
	public double calculateTotalExpenses();
	public List<ExpenseModel> descByDate(List<ExpenseModel> expenses);
	public List<List<ExpenseModel>> categorizeExpenses(List<ExpenseModel> totalExpenses); 
	public ExpenseModel findExpenseById(int id);
	public List<ExpenseModel> getAllExpenses();
	public void updateExpense(ExpenseModel expense);
	public void deleteExpense (int id);
	public List<ExpenseModel> getExpensesByDate(String filterDate);
	public double CalculateExpensesByDate(String filterDate);
}
