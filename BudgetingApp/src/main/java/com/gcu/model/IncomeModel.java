package com.gcu.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;

public class IncomeModel {
	
	@NotNull(message="Description is a required field")
	private String description;
	
	@NotNull(message="amount is a required field")
	private double amount;
	
	@NotNull(message="Date is a required field")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	private String notes;
	
	//constructor
	public IncomeModel(String description, double amount, Date date, String notes) {
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
