package com.example.demo.repository;

import java.util.Collection;
import java.util.List;
import com.example.demo.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AffectationProject;
import com.example.demo.entities.Project;

public interface AffectationProjectRepository extends JpaRepository<AffectationProject, Integer> {

	public List<AffectationProject> findByProject(Project proj);
	public List<AffectationProject> findByUser(Users user);

	
}
