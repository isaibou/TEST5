package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Deliverable;

public interface DeliverableRepository extends JpaRepository<Deliverable, Integer>{
	
	@Query("select count(e)>0 from Deliverable e where e.Name = ?1")
	Boolean checkTitleExist(String name);

}
