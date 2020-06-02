package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="users")
public class Users implements Serializable {
	
	@Id
	@Email
	private  String username;
	
	//@NotEmpty
	//@Length(min = 5, message = "*Your password must have at least 5 characters")
	private String password; 
	
	private boolean actived;
	
	@NotEmpty
	private String lastName;
	
	private Boolean isCustomer;
	
	private String Picture;
	
	@NotEmpty
	private String firstName;
	
	//@NotEmpty
	private String CIN;
    
	@NotEmpty
	@NumberFormat(pattern = "##########")
	private String Phone;
	@ManyToOne
	@JoinColumn(name = "customer_ID")
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Roles> roles;
	

	@OneToMany(mappedBy =   "userEmployee" , fetch = FetchType.LAZY)
	private Collection<InternalRequest> internalRequest;
	

	@OneToMany(mappedBy =   "userCustomer" , fetch = FetchType.LAZY)
	private Collection<ExternalRequest> externalRequest;
	
	@OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
	private Collection<Expenses> expenses;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Collection<Ticket> ticket;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Collection<AffectationProject> affectProj ;
	
	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private Collection<Task> tasks;
	@OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
	private Collection<ProjectUser> projUser;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String username, String password, boolean actived, String lastName, Boolean isCustomer, String picture,
			String firstName, String cIN, String phone, Customer customer, Collection<Roles> roles) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.lastName = lastName;
		this.isCustomer = isCustomer;
		Picture = picture;
		this.firstName = firstName;
		CIN = cIN;
		Phone = phone;
		this.customer = customer;
		this.roles = roles;
	}

	public Users(String username, String password, boolean actived, String lastName, String firstName, String cIN,
			String phone, Customer customer, Collection<Roles> roles) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.lastName = lastName;
		this.firstName = firstName;
		CIN = cIN;
		Phone = phone;
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


	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}

	public Collection<InternalRequest> getInternalRequest() {
		return internalRequest;
	}

	public void setInternalRequest(Collection<InternalRequest> internalRequest) {
		this.internalRequest = internalRequest;
	}

	public Collection<ExternalRequest> getExternalRequest() {
		return externalRequest;
	}

	public void setExternalRequest(Collection<ExternalRequest> externalRequest) {
		this.externalRequest = externalRequest;
	}

	public Boolean getIsCustomer() {
		return isCustomer;
	}

	public void setIsCustomer(Boolean isCustomer) {
		this.isCustomer = isCustomer;
	}

	public Collection<Expenses> getExpenses() {
		return expenses;
	}

	public void setExpenses(Collection<Expenses> expenses) {
		this.expenses = expenses;
	}


	public Collection<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Collection<Ticket> ticket) {
		this.ticket = ticket;
	}

	public Collection<AffectationProject> getAffectProj() {
		return affectProj;
	}

	public void setAffectProj(Collection<AffectationProject> affectProj) {
		this.affectProj = affectProj;
	}

	public Collection<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Collection<Task> tasks) {
		this.tasks = tasks;
	}

	public Collection<ProjectUser> getProjUser() {
		return projUser;
	}

	public void setProjUser(Collection<ProjectUser> projUser) {
		this.projUser = projUser;
	}

	
	
	
	
	


}