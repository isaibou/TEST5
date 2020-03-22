package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Reference;

public interface ReferenceRepository extends JpaRepository<Reference, Integer>{

}
