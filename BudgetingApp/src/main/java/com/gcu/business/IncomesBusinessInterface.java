package com.gcu.business;

import java.util.Date;
import java.util.List;

import com.gcu.data.entities.IncomeEntity;

public interface IncomesBusinessInterface {
	
	//describes the contract for the IncomesBusinessService layer that implements this interface
	public void init();
	public void destroy();
	public void addIncome(String description, double amount, Date date, String notes);
	public double calculateTotalIncomes();
	public List<IncomeEntity> descByDate();
}
