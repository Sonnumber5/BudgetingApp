package com.gcu.business;

import java.time.LocalDate;
import java.util.List;

import com.gcu.model.IncomeModel;

public interface IncomesBusinessInterface {
	
	//describes the contract for the IncomesBusinessService layer that implements this interface
	public void test();
	public void init();
	public void destroy();
	public void addIncome(String description, double amount, LocalDate date);
	List<IncomeModel> getIncomes();
}
