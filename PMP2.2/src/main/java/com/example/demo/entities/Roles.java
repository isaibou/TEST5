package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.TituloEleitoral;


@Entity
public class Roles  implements Serializable{
	@Id
	private String role;
	private String description;
	
		
	
	public Roles() {
		super();
	}
	public Roles(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	
	
	
	
}
