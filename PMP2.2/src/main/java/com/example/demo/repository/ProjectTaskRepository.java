package com.example.demo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.*;
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer>{
// List<ProjectTask> findByAffectProj(Collection<AffectationProject> affectProj);
 
}
