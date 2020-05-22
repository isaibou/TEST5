package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Frimware;
import com.example.demo.entities.RFP;

public interface FrimwareRepository extends JpaRepository<Frimware, Integer>{
	
	@Query("select count(e)>0 from Frimware e where e.name = ?1")
	Boolean checkTitleExist(String name);
	
	public List<Frimware> findByStatus(String status);

}
