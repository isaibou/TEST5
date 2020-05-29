package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.TypeExternalRequest;

public interface TypeExternalRequestRepository extends JpaRepository<TypeExternalRequest, Integer>{
	
	@Query("select count(e)>0 from TypeExternalRequest e where e.NameTypeExternelRequest = ?1")
	Boolean checkTitleExist(String nameTypeExternelRequest);


}
