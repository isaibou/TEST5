package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Task;
import com.example.demo.entities.Users;

public interface TaskRepository extends JpaRepository<Task, Integer>{

 public List<Task> findByUsers(Users u);
} 
