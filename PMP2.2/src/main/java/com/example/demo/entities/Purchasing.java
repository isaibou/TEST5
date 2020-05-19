package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;

@Entity
public class Purchasing implements Serializable{
	
	
	@Id
	@GeneratedValue
	private Integer Purchasing_ID;
	@NotEmpty(message = "*Please provide your First Name")
	private String FirstName;
	
	@NotEmpty(message = "*Please provide your Last Name")
	private String LastName;
	
	@NotEmpty(message = "*Please provide your Number Phone")
	@NumberFormat(pattern = "##########")
	private String Contact;
	
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String Email;
	//les relation avec customer
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	public Purchasing(Customer customer) {
		super();
		this.customer = customer;
	}


	//attribut customer de type Customer 
	//private Customer customer;
	
	
	


	public Purchasing() {
		super();
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
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
