package com.gcu.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;

//expense model which requires 3 properties: description, amount, and category

public class ExpenseModel {

	@NotNull(message="Description is a required field")
    private String description;
	
	@NotNull(message="Amount is a required field")
    private double amount;
	
	@NotNull(message="Category is a required field")
    private String category;
	
	@NotNull(message="Date is a required field")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
	
    private String notes;

    //constructor
    public ExpenseModel(String description, double amount, String category, Date date, String notes) {
        this.description = description;
        this.amount = amount;
        this.category = category;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
