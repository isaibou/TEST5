package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer>{

}
