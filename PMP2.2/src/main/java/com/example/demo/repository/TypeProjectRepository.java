package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.*;

public interface TypeProjectRepository extends JpaRepository<TypeProject, Integer>{
	
	@Query("select count(e)>0 from TypeProject e where e.NameType_Project = ?1")
	Boolean checkTitleExist(String nameType_Project);
	
	@Query("select e from TypeProject e where e.NameType_Project = ?1")
	List<TypeProject> searchByName(String nameType_Project);

}
