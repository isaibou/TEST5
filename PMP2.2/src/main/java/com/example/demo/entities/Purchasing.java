package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Purchasing implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Purchasing_ID;
	private String FirstName;
	private String LastName;
	private String Contact;
	private String Email;
	@OneToMany(mappedBy = "Purchasing",fetch = FetchType.LAZY)
	private Collection<Customer> customer;
	
	public Purchasing(Collection<Customer> customer) {
		super();
		this.customer = customer;
	}


	//attribut customer de type Customer 
	//private Customer customer;
	
	
	


	public Purchasing() {
		super();
	}


	public Collection<Customer> getCustomer() {
		return customer;
	}


	public void setCustomer(Collection<Customer> customer) {
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
