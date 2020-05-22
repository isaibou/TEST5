package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.RFP;
import com.example.demo.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer>{
	
	@Query("select count(e)>0 from Vendor e where e.NameVendor = ?1")
	Boolean checkTitleExist(String nameVendor);
	
	public List<Vendor> findByStatus(String status);

}
