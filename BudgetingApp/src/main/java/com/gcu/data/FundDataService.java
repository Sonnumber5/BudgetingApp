package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entities.FundEntity;
import com.gcu.data.repositories.FundRepository;

@Service
public class FundDataService implements DataAccessInterface<FundEntity>{
	@Autowired
	private FundRepository fundRepository;
	private JdbcTemplate jdbcTemplate;
	
	public FundDataService(FundRepository fundRepository, DataSource source) {
		this.fundRepository = fundRepository;
		this.jdbcTemplate = new JdbcTemplate(source);
	}
	
	@Override
	public List<FundEntity> findAll() {
		List<FundEntity> funds = new ArrayList<>();
		try {
			funds.addAll(fundRepository.findAll());
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return funds;
	}

	@Override
	public FundEntity findById(int id) {
		List<FundEntity> funds = fundRepository.findAll();
		for (FundEntity fund : funds) {
			if (id == fund.getId()) {
				return fund;
			}
		}
		return null;
	}

	@Override
	public boolean create(FundEntity fund) {
		String sql = "INSERT INTO FUNDS(NAME, GOAL, AMOUNT, NOTES) VALUES(?,?,?,?)";
		try {
			jdbcTemplate.update(sql, fund.getName(), fund.getGoal(), fund.getAmount(), fund.getNotes());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(FundEntity fund) {
		String sql = "UPDATE FUNDS SET NAME = ?, GOAL = ?, AMOUNT = ?, NOTES = ? WHERE ID = ?";
		try {
			jdbcTemplate.update(sql, fund.getName(), fund.getGoal(), fund.getAmount(), fund.getNotes(), fund.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		try {
			jdbcTemplate.update("DELETE FROM FUNDS WHERE ID = ?", id);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
