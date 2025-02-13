package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entities.ExpenseEntity;
import com.gcu.data.repositories.ExpenseRepository;

@Service
public class ExpenseDataService implements DataAccessInterface<ExpenseEntity>{
	@Autowired
	private ExpenseRepository expenseRepository;
	private JdbcTemplate jdbcTemplate;
	
	public ExpenseDataService(ExpenseRepository expenseRepository, DataSource source) {
		this.expenseRepository = expenseRepository;
		this.jdbcTemplate = new JdbcTemplate(source);
	}
	
	@Override
	public List<ExpenseEntity> findAll() {
		List<ExpenseEntity> expenses = new ArrayList<>();
		try {
			expenses.addAll(expenseRepository.findAll());
		}catch (Exception e){
			e.printStackTrace();
		}
		return expenses;
	}

	@Override
	public ExpenseEntity findById(int id) {
		List<ExpenseEntity> expenses = expenseRepository.findAll();
		for (ExpenseEntity expense : expenses) {
			if (id == expense.getId()) {
				return expense;
			}
		}
		return null;
	}

	@Override
	public boolean create(ExpenseEntity expense) {
		String sql = "INSERT INTO EXPENSES(DESCRIPTION, AMOUNT, CATEGORY, DATE, NOTES) VALUES(?,?,?,?,?)";
		try {
			jdbcTemplate.update(sql, expense.getDescription(), expense.getAmount(), expense.getCategory(), expense.getDate(), expense.getNotes());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(ExpenseEntity expense) {
		String sql = "UPDATE EXPENSES SET DESCRIPTION = ?, AMOUNT = ?, CATEGORY = ?, DATE = ?, NOTES = ?";
		try {
			jdbcTemplate.update(sql, expense.getDescription(), expense.getAmount(), expense.getCategory(), expense.getDate(), expense.getNotes());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		try {
			jdbcTemplate.update("DELETE FROM EXPENSES WHERE ID = ?", id);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
