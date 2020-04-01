package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Roles implements Serializable{
	@Id
	@GeneratedValue
	private Integer Role_ID; 
	private String NomRole;
	@OneToMany(targetEntity = Employe.class, mappedBy = "role", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<Employe> employee;
	
	
	public Roles() {
		super();
	}

	public Roles( String nomRole) {
		
		NomRole = nomRole;
	}

	public Integer getRole_ID() {
		return Role_ID;
	}

	public void setRole_ID(Integer role_ID) {
		Role_ID = role_ID;
	}

	public String getNomRole() {
		return NomRole;
	}

	public void setNomRole(String nomRole) {
		NomRole = nomRole;
	}

	public List<Employe> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employe> employee) {
		this.employee = employee;
	}

	
	
	

	
}
