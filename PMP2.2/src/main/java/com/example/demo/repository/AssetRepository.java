package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.AssetType;
import com.example.demo.entities.Assets;

public interface AssetRepository extends JpaRepository<Assets, Integer>{
	@Query("select count(e)>0 from Assets e where e.SerielNumber = ?1")
	Boolean checkTitleExist(String serielNumber);
	

}
