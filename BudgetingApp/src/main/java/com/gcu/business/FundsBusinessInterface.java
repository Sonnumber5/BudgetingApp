package com.gcu.business;

import com.gcu.data.entities.FundEntity;

public interface FundsBusinessInterface {
	
	//describes the contract between the FundsBusinessService class that implements this interface
	public void init();
	public void destroy();
	public void addFund(String name, double goal, double amount, String notes);
	public double addAmount(double currentAmount, double contribution);
	public double calculateTotalFunds();
}
