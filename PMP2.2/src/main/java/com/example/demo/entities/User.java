package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.example.demo.entities.*;

@Entity
@Table(name = "Users")
public class Users implements Serializable{
	@Id
	private String username;
	private String firstName;
	private String lastName;
	private String CIN;
	private String Picture;
	private String password;
	private boolean actived;
	@ManyToMany
	@JoinTable(name = "USERS_ROLES") 
	
	private Collection<Roles> roles;
	
	public Users() {
		super();
	}
	
	

	public Users(String username, String firstName, String lastName, String cIN, String picture, String password,
			boolean actived) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		CIN = cIN;
		Picture = picture;
		this.password = password;
		this.actived = actived;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

	
}
