package com.gcu.model;

public class BudgetModel {

	//budget model to have a budget amount property
	private double budgetAmount;

	//constructor
	public BudgetModel(double budgetAmount) {
		this.budgetAmount = budgetAmount;
	}
	
	public double getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(double budgetAmount) {
		this.budgetAmount = budgetAmount;
	}
	
	
}
