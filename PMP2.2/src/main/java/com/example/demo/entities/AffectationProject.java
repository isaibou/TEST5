package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AffectationProject {
	@Id
	@GeneratedValue
	private Integer Affectaion_Id;
	
	@ManyToOne
	@JoinColumn(name="PROJECT_ID")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "PROJECTTASK_ID")
	private ProjectTask projATsk;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user;
	
	@OneToOne(mappedBy = "affectationProject")
	private Task task;

	public AffectationProject() {
		super();
	}

	public Integer getAffectaion_Id() {
		return Affectaion_Id;
	}

	public void setAffectaion_Id(Integer affectaion_Id) {
		Affectaion_Id = affectaion_Id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	

	public ProjectTask getProjATsk() {
		return projATsk;
	}

	public void setProjATsk(ProjectTask projATsk) {
		this.projATsk = projATsk;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	
	
	
	
	
	
}
