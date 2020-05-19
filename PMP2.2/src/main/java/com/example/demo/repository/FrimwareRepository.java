package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Frimware;

public interface FrimwareRepository extends JpaRepository<Frimware, Integer>{
	
	@Query("select count(e)>0 from Frimware e where e.name = ?1")
	Boolean checkTitleExist(String name);

}
