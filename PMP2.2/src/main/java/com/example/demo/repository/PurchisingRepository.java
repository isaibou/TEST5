package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Purchasing;

public interface PurchisingRepository extends JpaRepository<Purchasing, Integer>{
	
	@Query("select count(e)>0 from Purchasing e where e.Email = ?1")
	Boolean checkTitleExist(String email);
	
	@Query("select e from Purchasing e where e.Email = ?1")
	List<Purchasing> searchByEmail(String email);

	

}
