package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Customer;
import com.example.demo.entities.RFP;
import com.example.demo.entities.TechnologyPartner;

public interface TechnologiePartnerRepository extends JpaRepository<TechnologyPartner, Integer>{
	
	@Query("select count(e)>0 from TechnologyPartner e where e.NameTechnologyPartner = ?1")
	Boolean checkTitleExist(String nameTechnologyPartner);
	
	@Query("select e from TechnologyPartner e where e.NameTechnologyPartner = ?1")
	List<TechnologyPartner> searchByName(String nameTechnologyPartner);
	
	public List<TechnologyPartner> findByStatus(String status);

}
