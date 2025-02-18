package com.gcu.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("FUND")
public class FundEntity {

	@Id
	private int id;
	
	@Column("NAME")
	private String name;
	
	@Column("GOAL")
	private double goal;
	
	@Column("AMOUNT")
	private double amount;
	
	@Column("NOTES")
	private String notes;
	
	public FundEntity() {};
	
	public FundEntity(int id, String name, double goal, double amount, String notes) {
		this.id = id;
		this.name = name;
		this.goal = goal;
		this.amount = amount;
		this.notes = notes;
	}
	
	public FundEntity(String name, double goal, double amount, String notes) {
		this.name = name;
		this.goal = goal;
		this.amount = amount;
		this.notes = notes;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
