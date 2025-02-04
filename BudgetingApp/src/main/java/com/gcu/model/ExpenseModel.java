package com.gcu.model;

import java.time.LocalDate;

//expense model which requires 3 properties: description, amount, and category

public class ExpenseModel {

    private String description;
    private double amount;
    private String category;
    private LocalDate date;
    private String notes;

    //constructor
    public ExpenseModel(String description, double amount, String category, LocalDate date, String notes) {
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
