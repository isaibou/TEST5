package com.example.demo.repository;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ProjectUser;
import com.example.demo.entities.Users;

public interface ProjectUserrepository extends JpaRepository<ProjectUser, Long> {
	
	
	public List<ProjectUser> findByUser(Users u);

}
