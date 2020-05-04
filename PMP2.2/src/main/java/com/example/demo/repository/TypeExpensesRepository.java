package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.TypeExpenses;

public interface TypeExpensesRepository extends JpaRepository<TypeExpenses, Integer> {
	

}
