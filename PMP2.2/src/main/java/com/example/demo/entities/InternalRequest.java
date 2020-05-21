package com.example.demo.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class InternalRequest implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer InternalRequest_ID;
	
	@NotEmpty
	private String Description;
	
	private String Status; 

	@DateTimeFormat()
	private Date SubmitedDate;
	
	private String Commentaire;
		
	@ManyToOne
	@JoinColumn( name="typeInternal_ID")
	private TypeInternalRequest typeInternalRequest;
	
	@ManyToOne
	@JoinColumn(name ="User_ID")
	private Users userEmployee;
	
	public InternalRequest() {
		super();
	}
	
	public InternalRequest(String description, String status, Date submitedDate, String commentaire,
			TypeInternalRequest typeInternalRequest) {
		super();
		Description = description;
		Status = status;
		SubmitedDate = submitedDate;
		Commentaire = commentaire;
		this.typeInternalRequest = typeInternalRequest;
	}






	public Integer getInternalRequest_ID() {
		return InternalRequest_ID;
	}

	public void setInternalRequest_ID(Integer internalRequest_ID) {
		InternalRequest_ID = internalRequest_ID;
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

	public TypeInternalRequest getTypeInternalRequest() {
		return typeInternalRequest;
	}

	public void setTypeInternalRequest(TypeInternalRequest typeInternalRequest) {
		this.typeInternalRequest = typeInternalRequest;
	}

	public Users getUserEmployee() {
		return userEmployee;
	}

	public void setUserEmployee(Users userEmployee) {
		this.userEmployee = userEmployee;
	}



	public String getCommentaire() {
		return Commentaire;
	}



	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}

	

	
	

	
	
	
}