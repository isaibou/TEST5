package com.example.demo.entities;

import java.io.Serializable;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Date;

import java.util.*;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Project implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Project_ID;
 
	@NotEmpty
	@Column(name="Name",length=30)
	private String Name;
	
	
	@NumberFormat(pattern = "#,###,###,###.##")
	private Double Amount;
	
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date  Year;
	
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date DeliveryDate;
	
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date TemporayAcceptanceDate;
	

	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date FinalTemporaryDate;
	
	private String DeliveryCertificate;
	//private String Uri;
    //private String Type;
    //private long Size;
	
	//@Column(name = "TechnologyPartners")
	//private String TechnologyPartners;

	@NumberFormat(pattern = "#,###")
	private int Warranty;
	
	@NumberFormat(pattern = "#,###")
	private int ExecutionTime;
	
	
	@NotEmpty
	private String Notes;
	
	@Column(name = "Status")
	private String status;
	
	@ManyToMany
	@JoinTable(name="ASSET_PROJECT")
	private Collection <Assets> assets;
	
	@ManyToMany
	private List<TechnologyPartner> technologypartner;  
	
	@ManyToOne
	@JoinColumn(name="typeProject_ID")
	private TypeProject typeProject;
	
	@ManyToOne
	@JoinColumn(name="RFP_ID")
	private RFP rfp;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Collection<Reference> reference;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Collection<Deliverable> deliverable;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Collection<AffectationProject> affectProj;
	
	@OneToMany(mappedBy = "project" , fetch = FetchType.LAZY)
	private Collection<ProjectUser> projUser;
	
	
	
	public Project() {
		super();
	}
	public Integer getProject_ID() {
		return Project_ID;
	}
	public void setProject_ID(Integer project_ID) {
		Project_ID = project_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public Date getYear() {
		return Year;
	}
	public void setYear(Date year) {
		Year = year;
	}
	public Date getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public Date getTemporayAcceptanceDate() {
		return TemporayAcceptanceDate;
	}
	public void setTemporayAcceptanceDate(Date temporayAcceptanceDate) {
		TemporayAcceptanceDate = temporayAcceptanceDate;
	}
	public Date getFinalTemporaryDate() {
		return FinalTemporaryDate;
	}
	public void setFinalTemporaryDate(Date finalTemporaryDate) {
		FinalTemporaryDate = finalTemporaryDate;
	}
	public String getDeliveryCertificate() {
		return DeliveryCertificate;
	}
	public void setDeliveryCertificate(String deliveryCertificate) {
		DeliveryCertificate = deliveryCertificate;
	}
	//public String getTechnologyPartners() {
		//return TechnologyPartners;
	//}
	//public void setTechnologyPartners(String technologyPartners) {
		//TechnologyPartners = technologyPartners;
	//}
	public int getWarranty() {
		return Warranty;
	}
	public void setWarranty(int warranty) {
		Warranty = warranty;
	}
	public int getExecutionTime() {
		return ExecutionTime;
	}
	public void setExecutionTime(int executionTime) {
		ExecutionTime = executionTime;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RFP getRfp() {
		return rfp;
	}
	public void setRfp(RFP rfp) {
		this.rfp = rfp;
	}
	public List<TechnologyPartner> getTechnologypartner() {
		return technologypartner;
	}
	public void setTechnologypartner(List<TechnologyPartner> technologypartner) {
		this.technologypartner = technologypartner;
	}
	public Collection<Assets> getAssets() {
	   return assets;
   }
	public void setAssets(Collection<Assets> assets) {
		this.assets = assets;
	}
	public void setTypeProject(TypeProject typeProject) {
		this.typeProject = typeProject;
	}
	public Collection<Reference> getReference() {
		return reference;
	}
	public void setReference(Collection<Reference> reference) {
		this.reference = reference;
	}
	public Collection<Deliverable> getDeliverable() {
		return deliverable;
	}
	public void setDeliverable(Collection<Deliverable> deliverable) {
		this.deliverable = deliverable;
	}
	public TypeProject getTypeProject() {
		return typeProject;
	}
	public Collection<AffectationProject> getAffectProj() {
		return affectProj;
	}
	public void setAffectProj(Collection<AffectationProject> affectProj) {
		this.affectProj = affectProj;
	}
	public Collection<ProjectUser> getProjUser() {
		return projUser;
	}
	public void setProjUser(Collection<ProjectUser> projUser) {
		this.projUser = projUser;
	}
	
	
	
	

}