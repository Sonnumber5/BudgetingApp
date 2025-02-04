package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entities.IncomeEntity;
import com.gcu.data.repositories.IncomeRepository;

@Service
public class IncomeDataService implements DataAccessInterface<IncomeEntity>{
	@Autowired
	private IncomeRepository incomeRepository;
	@SuppressWarnings("unused")
	private DataSource source;
	private JdbcTemplate jdbcTemplate;
	
	public IncomeDataService (IncomeRepository incomeRepository, DataSource source) {
		this.incomeRepository = incomeRepository;
		this.source = source;
		this.jdbcTemplate = new JdbcTemplate(source);
	}
	
	@Override
	public List<IncomeEntity> findAll(){
		List<IncomeEntity> incomes = new ArrayList<>();
		try {
			incomes.addAll(incomeRepository.findAll());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return incomes;
	}

	@Override
	public IncomeEntity findById(int id) {
		List<IncomeEntity> incomes = incomeRepository.findAll();
		for (IncomeEntity income : incomes) {
			if (id == income.getId()) {
				return income;
			}
		}
		return null;
	}

	@Override
	public boolean create(IncomeEntity income) {
		String sql = "INSERT INTO INCOME(DESCRIPTION, AMOUNT, DATE, NOTES) VALUES(?,?,?,?)";
		try {
			jdbcTemplate.update(sql, income.getDescription(), income.getAmount(), income.getDate(), income.getNotes());
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(IncomeEntity income, String fieldName, String newValue) {
		try {
			jdbcTemplate.update("UPDATE INCOME SET ? = ? WHERE ID = ?", fieldName, newValue, income.getId());
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		try {
			jdbcTemplate.update("DELETE FROM INCOME WHERE ID = ?", id);
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
