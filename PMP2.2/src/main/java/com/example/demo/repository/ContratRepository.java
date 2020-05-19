package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Integer>{
	
	@Query("select count(e)>0 from Contrat e where e.Title = ?1")
	Boolean checkTitleExist(String title);

}
