package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.AssetType;
import com.example.demo.entities.RFP;

public interface AssetTypeRepository extends JpaRepository<AssetType, Integer>{
	
	@Query("select count(e)>0 from AssetType e where e.Name = ?1")
	Boolean checkTitleExist(String Name);
	
	public List<AssetType> findByStatus(String status);

}
