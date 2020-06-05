package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Customer;
import com.example.demo.entities.RFP;

public interface RFPRepository extends JpaRepository<RFP, Integer>{
	
	
	@Query("select count(e)>0 from RFP e where e.Title = ?1")
	Boolean checkTitleExist(String title);
	
	@Query("select e from RFP e where e.Title = ?1")
	List<RFP> searchByName(String title);
	
	public List<RFP> findByStatusRFP(String statusRFP);
}
