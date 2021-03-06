package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class ExternalRequest implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer ExternalRequest_ID;
	
	@NotEmpty
	private String Description;
	
	private Boolean status; 
	
	private Date SubmitedDate;
	
	private String Commentaire;
	
	@ManyToOne
	@JoinColumn(name ="typeExternal_ID")
	private TypeExternalRequest typeExternalRequest;
	
	@ManyToOne
	@JoinColumn(name ="User_ID")
	private Users userCustomer;
	
	public ExternalRequest() {
		super();
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

	

	





	public Boolean getStatus() {
		return status;
	}











	public void setStatus(Boolean status) {
		this.status = status;
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






	public String getCommentaire() {
		return Commentaire;
	}






	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}


	

	
	

}