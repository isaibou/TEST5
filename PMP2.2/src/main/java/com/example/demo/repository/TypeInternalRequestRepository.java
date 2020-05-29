package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.TypeInternalRequest;

public interface TypeInternalRequestRepository extends JpaRepository<TypeInternalRequest, Integer>{
	
	@Query("select count(e)>0 from TypeInternalRequest e where e.NameTypeInternalRequest = ?1")
	Boolean checkTitleExist(String nameTypeInternalRequest);

}
