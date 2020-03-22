package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class TechnologyPartner implements Serializable{
	
	
	@Id
	@GeneratedValue
	private Integer TechnologyPartner_ID;
	private String NameTechnologyPartner;
	
	public TechnologyPartner() {
		super();
	}
	public TechnologyPartner(String nameTechnologyPartner) {
		super();
		NameTechnologyPartner = nameTechnologyPartner;
	}
	public Integer getTechnologyPartner_ID() {
		return TechnologyPartner_ID;
	}
	public void setTechnologyPartner_ID(Integer technologyPartner_ID) {
		TechnologyPartner_ID = technologyPartner_ID;
	}
	public String getNameTechnologyPartner() {
		return NameTechnologyPartner;
	}
	public void setNameTechnologyPartner(String nameTechnologyPartner) {
		NameTechnologyPartner = nameTechnologyPartner;
	}
	

}
