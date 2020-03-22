package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type_Project implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Type_Project_ID;
	private String NameType_Project;
	public Type_Project() {
		super();
	}
	public Type_Project(String nameType_Project) {
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
	
	
	

}
