package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.TypeDeliverable;

public interface TypeDeliverableRepository extends JpaRepository<TypeDeliverable, Integer>{
	
	@Query("select count(e)>0 from TypeDeliverable e where e.NameTypeDeliverable = ?1")
	Boolean checkTitleExist(String nameTypeDeliverable);

}
