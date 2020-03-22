package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class ProjectTask implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer ProjectTask_ID;
	private String NameProjectTask;
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
	

}
