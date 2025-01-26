package com.gcu.model;

import jakarta.validation.constraints.NotNull;

public class IncomeModel {
	
	// income model which requires 2 properties: description and amount
	@NotNull(message="Description is a required field")
	private String description;
	
	@NotNull(message="amount is a required field")
	private double amount;
	
	public IncomeModel(String description, double amount) {
		this.description = description;
		this.amount = amount;
	}

	//getters and setters
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
