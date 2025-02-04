package com.gcu.data.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entities.ExpenseEntity;

public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Integer>{
	@Override
	@Query(value = "SELECT * FROM EXPENSES")
	public List<ExpenseEntity> findAll();
}
