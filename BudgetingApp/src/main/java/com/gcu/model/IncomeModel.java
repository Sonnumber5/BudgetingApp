package com.gcu.model;

public class IncomeModel {
	
	private String description;
	private double amount;
	
	public IncomeModel(String description, double amount) {
		this.description = description;
		this.amount	= amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
