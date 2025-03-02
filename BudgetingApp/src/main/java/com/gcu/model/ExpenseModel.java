package com.gcu.model;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

public class ExpenseModel {

	private int id;
	
    private String description;
	
    private double amount;
	
    private String category;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
	
    private String notes;

    public ExpenseModel() {}
    
    public ExpenseModel(int id, String description, double amount, String category, Date date, String notes) {
        this.id = id;
    	this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.notes = notes;
    }
    
    public ExpenseModel(String description, double amount, String category, Date date, String notes) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.notes = notes;
    }

    //getters and setters
    
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
