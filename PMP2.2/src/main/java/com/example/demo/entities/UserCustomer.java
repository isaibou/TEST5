package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserCustomer implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer UserCustomer_ID;
	private String FirstName;
	private String LastName;
	private String Login;
	private String Passwor;
	private String Status;
	@OneToMany
	private Collection<Type_Project> projet; 
	
	
	public UserCustomer() {
		super();
	}


	public UserCustomer(String firstName, String lastName, String login, String passwor, String status) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Login = login;
		Passwor = passwor;
		Status = status;
	}


	public Integer getUserCustomer_ID() {
		return UserCustomer_ID;
	}


	public void setUserCustomer_ID(Integer userCustomer_ID) {
		UserCustomer_ID = userCustomer_ID;
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


	public String getLogin() {
		return Login;
	}


	public void setLogin(String login) {
		Login = login;
	}


	public String getPasswor() {
		return Passwor;
	}


	public void setPasswor(String passwor) {
		Passwor = passwor;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}
	
	
	
}
