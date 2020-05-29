package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Users;

public interface UserRepository  extends JpaRepository<Users, String>{
	
	public List<Users> findByIsCustomer(Boolean isCustomer);
	
	//sarah
	@Query("select count(e)>0 from Users e where e.username = ?1")
	Boolean checkTitleExist(String username);

}
