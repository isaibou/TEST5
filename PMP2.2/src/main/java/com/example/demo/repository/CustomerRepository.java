package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Purchasing;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	

}
