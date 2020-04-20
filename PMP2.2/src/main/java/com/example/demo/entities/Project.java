package com.example.demo.entities;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Project implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Project_ID;
 
	@NotNull 
	@Column(unique=true)
	private String Name;
	
	@Column(name = "TypeProject")
	private String TypeProject;
	
	@NumberFormat(pattern = "#,###,###,###.##")
	private Double Amount;
	
	//@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern= "yyyy")
	private DateFormat  Year= new SimpleDateFormat("yyyy") ;
	
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date DeliveryDate;
	
	
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date TemporayAcceptanceDate;
	

	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date FinalTemporaryDate;
	
	private String DeliveryCertificate;
	private String Uri;
    private String Type;
    private long Size;
	
	@Column(name = "TechnologyPartners")
	private String TechnologyPartners;

	@NumberFormat(pattern = "#,###")
	private int Warranty;
	
	@NumberFormat(pattern = "#,###")
	private int ExecutionTime;
	
	@Column(name = "Notes")
	private String Notes;
	
	@Column(name = "Status")
	private String Status;
	
	@OneToMany
	private Collection <Assets> assets;
	
	@ManyToMany(mappedBy = "Project")
	private List<TechnologyPartner> technologypartner;  

	
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
	public Project(String deliveryCertificate, String uri, String type, long size) {

		super();
		DeliveryCertificate = deliveryCertificate;
		Uri = uri;
		Type =type;
		Size = size;
	}
	public Project(String name, String typeProject, Double amount, DateFormat year, Date deliveryDate, Date temporayAcceptanceDate,
			Date finalTemporaryDate, String deliveryCertificate, String uri, String type, long size, String technologyPartners, int warranty,
			int executionTime, String notes, String status) {
		super();
		Name = name;
		TypeProject = typeProject;
		Amount = amount;
		Year = year;
		DeliveryDate = deliveryDate;
		TemporayAcceptanceDate = temporayAcceptanceDate;
		FinalTemporaryDate = finalTemporaryDate;
		DeliveryCertificate = deliveryCertificate;
		Uri = uri;
		Type =type;
		Size = size;
		TechnologyPartners = technologyPartners;
		Warranty = warranty;
		ExecutionTime = executionTime;
		Notes = notes;
		Status = status;
	}
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

	public String getUri() {
		return Uri;
	}

	public void setUri(String uri) {
		this.Uri = uri;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}

	public long getSize() {
		return Size;
	}

	public void setSize(long size) {
		this.Size = size;
	}
	
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public DateFormat getYear() {
		return Year;
	}
	public void setYear(DateFormat year) {
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
	public String getTechnologyPartners() {
		return TechnologyPartners;
	}
	public void setTechnologyPartners(String technologyPartners) {
		TechnologyPartners = technologyPartners;
	}
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
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getTypeProject() {
		return TypeProject;
	}
	public void setTypeProject(String typeProject) {
		TypeProject = typeProject;
	}

}
