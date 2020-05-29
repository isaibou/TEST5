package com.example.demo.repository;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Project;

public interface ProjetRepository extends JpaRepository<Project, Integer>{
	
	
	public List<Project> findByUsers(User u);
	
	@Query("select count(e)>0 from Project e where e.Name = ?1")
	Boolean checkTitleExist(String name);
	public List<Project> findByStatus(String status);  
	

}
