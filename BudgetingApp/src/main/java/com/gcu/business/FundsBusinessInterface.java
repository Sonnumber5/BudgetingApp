package com.gcu.business;

import java.util.List;

import com.gcu.model.FundModel;

public interface FundsBusinessInterface {
	
	//describes the contract between the FundsBusinessService class that implements this interface
	public void init();
	public void destroy();
	public void addFund(String name, double goal, double amount, String notes);
	public double addAmount(double currentAmount, double contribution);
	public double calculateTotalFunds();
	public void deleteFund(int id);
	public void updateFund(FundModel fund);
	public FundModel findFundById(int id);
	public List<FundModel> findAllFunds();
}
