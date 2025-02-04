package com.gcu.business;

import java.time.LocalDate;

public interface ExpensesBusinessInterface {
	
	//describes the contract between the ExpensesBusinessService class that implements this interface
	public void init();
	public void destroy();
	public void addExpense(String description, double amount, String category, LocalDate date, String notes);
}
