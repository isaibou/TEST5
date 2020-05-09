package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AssetType;
import com.example.demo.entities.Assets;

public interface AssetRepository extends JpaRepository<Assets, Integer>{
	//Optional<Assets> findById(Double Assetid);
	

}
