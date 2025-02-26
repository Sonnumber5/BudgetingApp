package com.gcu.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ExpenseDataService;
import com.gcu.data.entities.ExpenseEntity;
import com.gcu.model.ExpenseModel;

//main business logic for the expenses
public class ExpenseBusinessService implements ExpenseBusinessInterface {

	@Autowired
	private ExpenseDataService expenseDataService;

	// ------------------- ADD EXPENSE ------------------- //

	// used too add an expense item to the list
	@Override
	public void addExpense(String description, double amount, String category, Date date, String notes) {
		ExpenseEntity expense = new ExpenseEntity(description, amount, category, date, notes);
		try {
			expenseDataService.create(expense);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------------------- ORGANIZE ------------------- //

	@Override
	public double calculateTotalExpenses() {
		List<ExpenseEntity> expenses = expenseDataService.findAll();
		double total = 0.00;
		for (ExpenseEntity expense : expenses) {
			total += expense.getAmount();
		}
		return total;

	}

	@Override
	public List<ExpenseModel> descByDate(List<ExpenseModel> expenses) {
		return expenses.stream().sorted(Comparator.comparing(ExpenseModel::getDate).reversed()).toList();
	}

	@Override
	public List<List<ExpenseModel>> categorizeExpenses(List<ExpenseModel> totalExpenses) {
		Map<String, List<ExpenseModel>> bucket = new HashMap<>();

		for (ExpenseModel expense : totalExpenses) {
			if (!bucket.containsKey(expense.getCategory())) {
				bucket.put(expense.getCategory(), new ArrayList<>());
			}
			bucket.get(expense.getCategory()).add(expense);
		}

		// Sort each category by date (descending order)
		for (List<ExpenseModel> categoryExpenses : bucket.values()) {
			categoryExpenses.sort(Comparator.comparing(ExpenseModel::getDate).reversed());
		}

		List<List<ExpenseModel>> result = new ArrayList<>();
		for (List<ExpenseModel> list : bucket.values()) {
			result.add(list);
		}
		return result;
	}

	// ------------------- FIND ------------------- //

	@Override
	public ExpenseModel findExpenseById(int id) {
		ExpenseEntity expense = expenseDataService.findById(id);

		return new ExpenseModel(expense.getId(), expense.getDescription(), expense.getAmount(), expense.getCategory(),
				expense.getDate(), expense.getNotes());
	}

	@Override
	public List<ExpenseModel> getAllExpenses() {
		List<ExpenseEntity> expenseEntities = expenseDataService.findAll();
		List<ExpenseModel> expenses = new ArrayList<>();

		for (ExpenseEntity entity : expenseEntities) {
			expenses.add(new ExpenseModel(entity.getId(), entity.getDescription(), entity.getAmount(),
					entity.getCategory(), entity.getDate(), entity.getNotes()));
		}

		return expenses;
	}

	// ------------------- UPDATE ------------------- //

	@Override
	public void updateExpense(ExpenseModel expense) {

		ExpenseEntity expenseEntity = expenseDataService.findById(expense.getId());

		expenseEntity.setDescription(expense.getDescription());
		expenseEntity.setAmount(expense.getAmount());
		expenseEntity.setCategory(expense.getCategory());
		expenseEntity.setDate(expense.getDate());
		expenseEntity.setNotes(expense.getNotes());

		expenseDataService.update(expenseEntity);
	}

	// ------------------- DELETE ------------------- //

	@Override
	public void deleteExpense(int id) {
		expenseDataService.delete(id);
	}
	
	// ------------------- LIFECYCLE METHODS ------------------- //

	@Override
	public void init() {
		System.out.println("init test from ExpensesBusinessService");
	}

	@Override
	public void destroy() {
		System.out.println("destroy test from ExpensesBusinessService");
	}

}
