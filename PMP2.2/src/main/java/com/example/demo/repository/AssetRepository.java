package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Assets;

public interface AssetRepository extends JpaRepository<Assets, Integer>{
	

}
