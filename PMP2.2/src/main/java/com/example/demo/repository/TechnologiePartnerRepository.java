package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.TechnologyPartner;

public interface TechnologiePartnerRepository extends JpaRepository<TechnologyPartner, Integer>{
	
	@Query("select count(e)>0 from TechnologyPartner e where e.NameTechnologyPartner = ?1")
	Boolean checkTitleExist(String nameTechnologyPartner);

}
