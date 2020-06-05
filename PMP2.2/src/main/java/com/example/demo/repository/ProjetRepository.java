package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Project;
import com.example.demo.entities.RFP;

public interface ProjetRepository extends JpaRepository<Project, Integer>{
	
	@Query("select count(e)>0 from Project e where e.Name = ?1")
	Boolean checkTitleExist(String name);
	
	@Query("select e from Project e where e.Name = ?1")
	List<Project> searchByName(String name);
	
	public List<Project> findByStatus(String status);

}
