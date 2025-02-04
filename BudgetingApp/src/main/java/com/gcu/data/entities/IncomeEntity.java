package com.gcu.data.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("INCOME")
public class IncomeEntity {
	@Id
	private int id;
	
	@Column("DESCRIPTION")
	private String description;

	@Column("AMOUNT")
	private double amount;
	
	@Column("DATE")
	private LocalDate date;
	
	@Column("NOTES")
	private String notes;
	
	public IncomeEntity(){}
	
	public IncomeEntity(int id, String description, double amount, LocalDate date, String notes) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.notes = notes;
	}
	
	public IncomeEntity(String description, double amount, LocalDate date, String notes) {
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.notes = notes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
