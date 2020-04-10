package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users implements Serializable {
	@Id

	private  String username;
	private String password; 
	private boolean actived;
	private String lastName;
	private String firstName;
	private String CIN; 
	@ManyToOne
	@JoinColumn(name = "customer_ID")
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Roles> roles;
	
	

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	public Users(String username, String password, boolean actived, String lastName, String firstName, String cIN,
			Customer customer, Collection<Roles> roles) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.lastName = lastName;
		this.firstName = firstName;
		CIN = cIN;
		this.customer = customer;
		this.roles = roles;
	}





	public Users(String username, String password, boolean actived, String lastName, String firstName, String cIN,
			Customer customer) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.lastName = lastName;
		this.firstName = firstName;
		CIN = cIN;
		this.customer = customer;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	} 
	
	
	
	

}
