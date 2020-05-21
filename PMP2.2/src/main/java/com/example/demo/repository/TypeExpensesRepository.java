package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.TypeExpenses;

public interface TypeExpensesRepository extends JpaRepository<TypeExpenses, Integer> {
	
	@Query("select count(e)>0 from TypeExpenses e where e.NameTypeExpenses = ?1")
	Boolean checkTitleExist(String nameTypeExpenses);
	

}
