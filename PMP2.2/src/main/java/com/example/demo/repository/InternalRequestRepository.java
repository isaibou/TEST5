package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.InternalRequest;

public interface InternalRequestRepository extends JpaRepository<InternalRequest, Integer>{

}
