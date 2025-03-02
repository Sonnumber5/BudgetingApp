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
	private JdbcTemplate jdbcTemplate;
	
	public IncomeDataService (IncomeRepository incomeRepository, DataSource source) {
		this.incomeRepository = incomeRepository;
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
    public boolean update(IncomeEntity income) {
        String sql = "UPDATE INCOME SET DESCRIPTION = ?, AMOUNT = ?, DATE = ?, NOTES = ? WHERE ID = ?";
        try {
            jdbcTemplate.update(sql, income.getDescription(), income.getAmount(), income.getDate(), income.getNotes(), income.getId());
        } catch (Exception e) {
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
