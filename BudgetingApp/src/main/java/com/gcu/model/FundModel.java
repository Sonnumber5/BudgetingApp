package com.gcu.model;

import jakarta.validation.constraints.NotNull;

public class FundModel {

	@NotNull(message="Name is a required field")
	private String name;
	
	@NotNull(message="Goal is a required field")
	private double goal;
	
	@NotNull(message="Amount is a required field")
	private double amount;
	
	private String notes;
	
	public FundModel(String name, double goal, double amount, String notes) {
		this.name = name;
		this.goal = goal;
		this.amount = amount;
		this.notes = notes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
