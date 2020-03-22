package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Roles implements Serializable{
	@Id
	@GeneratedValue
	private Integer Role_ID; 
	private String NomRole;
	
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
	
	
	
	

	
}
