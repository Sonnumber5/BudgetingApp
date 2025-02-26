package com.gcu.data.repositories;

import com.gcu.data.entities.IncomeEntity;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IncomeRepository extends CrudRepository<IncomeEntity, Integer> {

    @Override
    @Query(value = "SELECT * FROM INCOME")
    public List<IncomeEntity> findAll();
}
