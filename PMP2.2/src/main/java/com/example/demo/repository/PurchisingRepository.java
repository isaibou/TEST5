package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Purchasing;

public interface PurchisingRepository extends JpaRepository<Purchasing, Integer>{

}
