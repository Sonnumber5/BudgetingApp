package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.ExpenseModel;
import com.gcu.model.IncomeModel;

public class ExpensesBusinessService implements ExpensesBusinessInterface {

	private List<ExpenseModel> expenses = new ArrayList<>();
	
	@Override
	public void test() {
		System.out.println("Hello from the ExpensesBusinessService");
	}
	
	@Override
    public void addExpense(String description, double amount, String category) {
        expenses.add(new ExpenseModel(description, amount, category));  
	}
        
	@Override
	public List<ExpenseModel> getExpenses(){
        
        return expenses;
	}
	
	@Override
	public void init() {
		System.out.println("init test from ExpensesBusinessService");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy test from ExpensesBusinessService");
	}
}
