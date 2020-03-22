package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserCustomer;

public interface UserCustomerRepository extends JpaRepository<UserCustomer, Integer>{

}
