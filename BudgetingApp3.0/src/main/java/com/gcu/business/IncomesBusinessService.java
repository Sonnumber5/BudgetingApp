package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.IncomeModel;

public class IncomesBusinessService implements IncomesBusinessInterface {

	private List<IncomeModel> incomes = new ArrayList<>();
	
	@Override
	public void test() {
		System.out.println("Hello from the IncomesBusinessService");
	}
	
	@Override
    public void addIncome(String description, double amount) {
        incomes.add(new IncomeModel(description, amount));  
    }

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
