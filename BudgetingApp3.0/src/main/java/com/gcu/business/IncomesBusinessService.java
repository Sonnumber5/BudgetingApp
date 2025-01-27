package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.IncomeModel;

//main business logic for the income 
public class IncomesBusinessService implements IncomesBusinessInterface {

	private List<IncomeModel> incomes = new ArrayList<>();
	
	@Override
	public void test() {
		System.out.println("Hello from the IncomesBusinessService");
	}
	
	//adds an income item to the list of IncomeModels 
	@Override
    public void addIncome(String description, double amount) {
        incomes.add(new IncomeModel(description, amount));  
    }

	//retreives all income items 
	@Override
	public List<IncomeModel> getIncomes(){
        return incomes;
	}
	
	@Override
	public void init() {
		System.out.println("init test from IncomesBusinessService");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy test from IncomesBusinessService");
	}
}
