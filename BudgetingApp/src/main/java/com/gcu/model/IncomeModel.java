package com.gcu.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class IncomeModel {
	
	@NotNull(message="Description is a required field")
	private String description;
	
	@NotNull(message="amount is a required field")
	private double amount;
	
	@NotNull(message="Date is a required field")
	private LocalDate date;
	
	private String notes;
	
	//constructor
	public IncomeModel(String description, double amount, LocalDate date, String notes) {
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.notes = notes;
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
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
