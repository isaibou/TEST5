package com.example.demo.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.example.demo.entities.*;

@Entity
public class Employe implements Serializable{
	@Id
	@GeneratedValue
	private Integer Employe_ID;
	private String FirstName;
	private String LastName;
	private String CIN;
	private String Picture;
	private String Password;
	private String Login;
	private String Status;
	@ManyToOne
	@JoinColumn(name = "roles_id")
	private Roles role;
	
	public Employe() {
		super();
	}


	public Employe(String firstName, String lastName, String cIN, String picture, String password, String login,
			String status) {
		super();
		FirstName = firstName;
		LastName = lastName;
		CIN = cIN;
		Picture = picture;
		Password = password;
		Login = login;
		Status = status;
	}


	public Integer getEmploye_ID() {
		return Employe_ID;
	}


	public void setEmploye_ID(Integer employe_ID) {
		Employe_ID = employe_ID;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getCIN() {
		return CIN;
	}


	public void setCIN(String cIN) {
		CIN = cIN;
	}


	public String getPicture() {
		return Picture;
	}


	public void setPicture(String picture) {
		Picture = picture;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getLogin() {
		return Login;
	}


	public void setLogin(String login) {
		Login = login;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	
}
