package com.example.demo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.*;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer>{
	
	@Query("select count(e)>0 from ProjectTask e where e.NameProjectTask = ?1")
	Boolean checkTitleExist(String nameProjectTask);


// List<ProjectTask> findByAffectProj(Collection<AffectationProject> affectProj);

}
