package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.DataCenter;

public interface DataCenterRepository  extends  JpaRepository<DataCenter, Long>{
	
	public Page<DataCenter> findByAdress(String n, Pageable pageable); 

	@Query("select d from DataCenter d where d.Adress like:x")
	public List<DataCenter> cherhcerAdress(@Param("x")String m);

}
