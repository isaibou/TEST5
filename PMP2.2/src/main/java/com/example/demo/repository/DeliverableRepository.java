package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Deliverable;

public interface DeliverableRepository extends JpaRepository<Deliverable, Integer>{

}
