package com.gcu.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

//root element for XML serialization and deserialization 
@XmlRootElement(name = "epxenses")
public class ExpenseList {
	
	// a list that holds IncomeModel objects 
    private List<ExpenseModel> expenses = new ArrayList<>();

    //binds this method to the income element in XML
    @XmlElement(name = "expense") 
    public List<ExpenseModel> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<ExpenseModel> expenses) {
        this.expenses = expenses;
    }
}
