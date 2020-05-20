package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.*;

public interface TypeProjectRepository extends JpaRepository<TypeProject, Integer>{
	
	@Query("select count(e)>0 from TypeProject e where e.NameType_Project = ?1")
	Boolean checkTitleExist(String nameType_Project);

}
