package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotEmpty;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class RFP implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer RFP_ID;
	
	@NotEmpty
	@Column (name="Title",length=30)
	private String Title; 
	
	@NotEmpty
	private String Description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date RealaseDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ReponseDateTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date NotificationDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date RequestOfExecutionDate;
	
	
	private String RequestFile;
	
	private String ResponseFile;
	private String statusRFP;
	
	@OneToMany(mappedBy = "rfp" , fetch = FetchType.LAZY)
	private Collection<Project> project;
	
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	
	@OneToMany
	private Collection <Contrat> Contrat;
	
	
	public Collection<Contrat> getContrat() {
		return Contrat;
	}

	public void setContrat(Collection<Contrat> contrat) {
		Contrat = contrat;
	}
	
	public RFP(Customer customer) {
		super();
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
}

	public RFP() {
		super();
	}
	
	public Integer getRFP_ID() {
		return RFP_ID;
	}
	public void setRFP_ID(Integer rFP_ID) {
		RFP_ID = rFP_ID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getRealaseDate() {
		return RealaseDate;
	}
	public void setRealaseDate(Date realaseDate) {
		RealaseDate = realaseDate;
	}
	public Date getReponseDateTime() {
		return ReponseDateTime;
	}
	public void setReponseDateTime(Date reponseDateTime) {
		ReponseDateTime = reponseDateTime;
	}
	public Date getNotificationDate() {
		return NotificationDate;
	}
	public void setNotificationDate(Date notificationDate) {
		NotificationDate = notificationDate;
	}
	public Date getRequestOfExecutionDate() {
		return RequestOfExecutionDate;
	}
	public void setRequestOfExecutionDate(Date requestOfExecutionDate) {
		RequestOfExecutionDate = requestOfExecutionDate;
	}
	public String getRequestFile() {
		return RequestFile;
	}
	public void setRequestFile(String requestFile) {
		RequestFile = requestFile;
	}
	public String getResponseFile() {
		return ResponseFile;
	}
	public void setResponseFile(String responseFile) {
		ResponseFile = responseFile;
	}
	public String getStatusRFP() {
		return statusRFP;
	}
	
	public void setStatusRFP(String statusRFP) {
		this.statusRFP = statusRFP;
	}

	public Collection<Project> getProject() {
		return project;
	}

	public void setProject(Collection<Project> project) {
		this.project = project;
	}
	

}
