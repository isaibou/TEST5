package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.*;

public interface ExpensesRepository extends JpaRepository<Expenses, Integer>{

}