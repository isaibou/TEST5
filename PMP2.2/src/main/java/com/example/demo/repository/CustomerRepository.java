package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Purchasing;

@Repository 
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
