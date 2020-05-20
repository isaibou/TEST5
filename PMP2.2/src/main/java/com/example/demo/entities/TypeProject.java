package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class TypeProject implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Type_Project_ID;
	
	@NotEmpty
	private String NameType_Project;
	
	@ManyToMany
	@JoinTable(name="TypeProject_projectTask")
	private Collection<ProjectTask> projectTask;
	
	@OneToMany(mappedBy = "typeProject", fetch = FetchType.LAZY)
	private Collection<Project> project;
	
	public TypeProject() {
		super();
	}
	public TypeProject(String nameType_Project) {
		super();
		NameType_Project = nameType_Project;
	}
	public Integer getType_Project_ID() {
		return Type_Project_ID;
	}
	public void setType_Project_ID(Integer type_Project_ID) {
		Type_Project_ID = type_Project_ID;
	}
	public String getNameType_Project() {
		return NameType_Project;
	}
	public void setNameType_Project(String nameType_Project) {
		NameType_Project = nameType_Project;
	}
	public Collection<ProjectTask> getProjectTask() {
		return projectTask;
	}
	public void setProjectTask(Collection<ProjectTask> projectTask) {
		this.projectTask = projectTask;
	}
	public Collection<Project> getProject() {
		return project;
	}
	public void setProject(Collection<Project> project) {
		this.project = project;
	}
	
	
	

}
