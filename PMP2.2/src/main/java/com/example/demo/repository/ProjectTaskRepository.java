package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ProjectTask;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer>{

}
