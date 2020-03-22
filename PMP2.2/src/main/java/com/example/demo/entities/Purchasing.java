package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Purchasing implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Purchasing_ID;
	private String FirstName;
	private String LastName;
	private String Contact;
	private String Email;
	
	
	public Purchasing() {
		super();
	}


	public Purchasing(String firstName, String lastName, String contact, String email) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Contact = contact;
		Email = email;
	}


	public Integer getPurchasing_ID() {
		return Purchasing_ID;
	}


	public void setPurchasing_ID(Integer purchasing_ID) {
		Purchasing_ID = purchasing_ID;
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


	public String getContact() {
		return Contact;
	}


	public void setContact(String contact) {
		Contact = contact;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}

	

}
