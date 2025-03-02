package com.gcu.business;

import java.util.Date;
import java.util.List;

import com.gcu.model.IncomeModel;

public interface IncomeBusinessInterface {
	
	//describes the contract for the IncomesBusinessService layer that implements this interface
	public void init();
	public void destroy();
	public void addIncome(String description, double amount, Date date, String notes);
	public double calculateTotalIncomes();
	public List<IncomeModel> descByDate(List<IncomeModel> incomes);
	public List<IncomeModel> getAllIncomes();
	public void deleteIncome(int id);
	public IncomeModel findIncomeById(int id);
	public void updateIncome(IncomeModel income);
	public List<IncomeModel> getIncomeByDate(String filterDate);
	public double CalculateIncomesByDate(String filterDate);
}
