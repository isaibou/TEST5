package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExternalRequest implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer ExternalRequest_ID;
	private String Description;
	private String Status; 
	private Date SubmitedDate;
	
	@ManyToOne
	@JoinColumn(name ="typeExternal_ID")
	private TypeExternalRequest typeExternalRequest;
	
	
	
	@ManyToOne
	@JoinColumn(name ="User_ID")
	private Users userCustomer;
	
	

	
	public ExternalRequest() {
		super();
	}
	
	

	public ExternalRequest(String description, String status, Date submitedDate) {
		super();
		Description = description;
		Status = status;
		SubmitedDate = submitedDate;
	}



	public Integer getExternalRequest_ID() {
		return ExternalRequest_ID;
	}

	public void setExternalRequest_ID(Integer externalRequest_ID) {
		ExternalRequest_ID = externalRequest_ID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getSubmitedDate() {
		return SubmitedDate;
	}

	public void setSubmitedDate(Date submitedDate) {
		SubmitedDate = submitedDate;
	}



	public TypeExternalRequest getTypeExternalRequest() {
		return typeExternalRequest;
	}



	public void setTypeExternalRequest(TypeExternalRequest typeExternalRequest) {
		this.typeExternalRequest = typeExternalRequest;
	}



	public Users getUserCustomer() {
		return userCustomer;
	}



	public void setUserCustomer(Users userCustomer) {
		this.userCustomer = userCustomer;
	}


	

	
	

}
