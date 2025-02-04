package com.gcu.business;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.IncomeDataService;
import com.gcu.data.entities.IncomeEntity;

//main business logic for the income 
public class IncomesBusinessService implements IncomesBusinessInterface {
	
	@Autowired
	private IncomeDataService incomeDataService;
	
	@Override
    public void addIncome(String description, double amount, LocalDate date, String notes) {
        IncomeEntity income = new IncomeEntity(description, amount, date, notes);
        try {
        	incomeDataService.create(income);
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
	
	@Override
	public void init() {
		System.out.println("IncomesBusinessService init method call");
	}
	
	@Override
	public void destroy() {
		System.out.println("IncomesBusinessService destroy method call");
	}
}
