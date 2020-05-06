package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class TechnologyPartner implements Serializable{
	
	
	
	@Id
	@GeneratedValue
	private Integer TechnologyPartner_ID;
	private String NameTechnologyPartner;
	private String TechnologyPartnerFile;
	private String Status;
	
	
	@ManyToMany
	private List<Project> project = new ArrayList<Project>(); 

	@ManyToMany
	@JoinTable(name = "project_technologypartner",
			joinColumns = @JoinColumn(name = "TechnologyPartner_ID"),
			inverseJoinColumns = @JoinColumn(name = "Project_ID"))
	private Set<Project> Project;
	
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
	public TechnologyPartner(String nameTechnologyPartner, String status, String technologyPartnerFile) {
		super();
		NameTechnologyPartner = nameTechnologyPartner;
		Status = status;
		TechnologyPartnerFile = technologyPartnerFile;
	}
	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
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
