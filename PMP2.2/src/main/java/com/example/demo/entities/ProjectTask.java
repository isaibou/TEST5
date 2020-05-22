package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.validation.constraints.NotEmpty;

import javax.persistence.OneToMany;



@Entity
public class ProjectTask implements Serializable{
	
	@Id
	@GeneratedValue
	
	private Integer ProjectTask_ID;
	@NotEmpty
	private String NameProjectTask;
	
	@ManyToMany
	@JoinTable(name="TypeProject_projectTask")
	private Collection<TypeProject> typeProject;
	
	@OneToMany(mappedBy = "projATsk", fetch = FetchType.LAZY)
	private Collection<AffectationProject> affectProj;
	
	
	
	public ProjectTask() {
		super();
	}
	public ProjectTask(String nameProjectTask) {
		super();
		NameProjectTask = nameProjectTask;
	}
	public Integer getProjectTask_ID() {
		return ProjectTask_ID;
	}
	public void setProjectTask_ID(Integer projectTask_ID) {
		ProjectTask_ID = projectTask_ID;
	}
	public String getNameProjectTask() {
		return NameProjectTask;
	}
	public void setNameProjectTask(String nameProjectTask) {
		NameProjectTask = nameProjectTask;
	}
	public Collection<TypeProject> getTypeProject() {
		return typeProject;
	}
	public void setTypeProject(Collection<TypeProject> typeProject) {
		this.typeProject = typeProject;
	}
	public Collection<AffectationProject> getAffectProj() {
		return affectProj;
	}
	public void setAffectProj(Collection<AffectationProject> affectProj) {
		this.affectProj = affectProj;
	}
	

	
}
