package com.gcu.data.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entities.FundEntity;

public interface FundRepository extends CrudRepository<FundEntity, Integer>{

	@Override
	@Query(value = "SELECT * FROM FUNDS")
	public List<FundEntity> findAll();
}
