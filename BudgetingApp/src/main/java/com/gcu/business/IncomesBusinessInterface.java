package com.gcu.business;

import java.time.LocalDate;
import java.util.List;

import com.gcu.data.entities.ExpenseEntity;

public interface IncomesBusinessInterface {
	
	//describes the contract for the IncomesBusinessService layer that implements this interface
	public void init();
	public void destroy();
	public void addIncome(String description, double amount, LocalDate date, String notes);
}
