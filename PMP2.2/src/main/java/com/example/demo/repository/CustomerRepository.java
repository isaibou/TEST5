package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Purchasing;
import com.example.demo.entities.RFP;

@Repository 
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select count(e)>0 from Customer e where e.Name = ?1")
	Boolean checkTitleExist(String name);
	
	public List<Customer> findByStatus(String status);
	
	public List<Customer> findByVip(String vip);
	

}
