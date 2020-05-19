package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Project;

public interface ProjetRepository extends JpaRepository<Project, Integer>{
	
	@Query("select count(e)>0 from Project e where e.Name = ?1")
	Boolean checkTitleExist(String name);

}
