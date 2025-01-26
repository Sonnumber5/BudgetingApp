package com.gcu.business;

import java.util.List;

import com.gcu.model.IncomeModel;

public interface IncomesBusinessInterface {
	
	public void test();
	public List<IncomeModel> getIncomes();
	public void init();
	public void destroy();
	public void addIncome(String description, double amount);
}
