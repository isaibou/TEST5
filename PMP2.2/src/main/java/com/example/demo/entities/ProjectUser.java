package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ProjectUser {
	@Id
	@GeneratedValue
	private Long projectUser_ID;
	@ManyToOne
	private  Users user;
	@ManyToOne
	private Project project;
	
	
	
	
	
	public ProjectUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getProjectUser_ID() {
		return projectUser_ID;
	}
	public void setProjectUser_ID(Long projectUser_ID) {
		this.projectUser_ID = projectUser_ID;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

	
	
	
	
}
