package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.ExpenseModel;
import com.gcu.model.IncomeModel;

//main business logic for the expenses
public class ExpensesBusinessService implements ExpensesBusinessInterface {

	//list of all expenses added by the user
	private List<ExpenseModel> expenses = new ArrayList<>();
	
	@Override
	public void test() {
		System.out.println("Hello from the ExpensesBusinessService");
	}
	
	//used too add an expense item to the list
	@Override
    public void addExpense(String description, double amount, String category) {
        expenses.add(new ExpenseModel(description, amount, category));  
	}
        
	//retrieves all expense items
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
