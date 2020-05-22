package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.InternalRequest;
import com.example.demo.entities.RFP;

public interface InternalRequestRepository extends JpaRepository<InternalRequest, Integer>{
	
	
	//@Query("select i from InternalRequest i where i.Status =1")
	//public List<InternalRequest> internalRequestWaiting();
	
   List<InternalRequest> findByStatus(String status);


}
