package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class TechnologyPartner implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TechnologyPartner_ID;
	
	@NotEmpty
	@Column (name="NameTechnologyPartner")
	private String NameTechnologyPartner;
	
	private String TechnologyPartnerFile;
	
	private String status;
	
	
	@ManyToMany
	private List<Project> project = new ArrayList<Project>(); 

	
	
	public List<Project> getproject() {
		return project;
	}
	
	
	/*public List<Project> getProject() {
		return project;
	}*/


	public void setProject(List<Project> project) {
		this.project = project;
	}


	public TechnologyPartner() {
		super();
	}
	
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Project> getProject() {
		return project;
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


	public String getTechnologyPartnerFile() {
		return TechnologyPartnerFile;
	}


	public void setTechnologyPartnerFile(String technologyPartnerFile) {
		TechnologyPartnerFile = technologyPartnerFile;
	}
	

}
