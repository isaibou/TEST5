package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Project implements Serializable{
	
	
	@Id
	@GeneratedValue
	private Integer Project_ID;
	@Column(name = "Name")
	private String Name;
	private Double Amount;
	private Date Year;
	private Date DeliveryDate;
	private Date TemporayAcceptanceDate;
	private Date FinalTemporaryDate;
	private String DeliveryCertificate;
	private String TechnologyPartners;
	private int Warranty;
	private int ExecutionTime;
	private String Notes;
	private String Status;
	public Project() {
		super();
	}
	public Project(String name, Double amount, Date year, Date deliveryDate, Date temporayAcceptanceDate,
			Date finalTemporaryDate, String deliveryCertificate, String technologyPartners, int warranty,
			int executionTime, String notes, String status) {
		super();
		Name = name;
		Amount = amount;
		Year = year;
		DeliveryDate = deliveryDate;
		TemporayAcceptanceDate = temporayAcceptanceDate;
		FinalTemporaryDate = finalTemporaryDate;
		DeliveryCertificate = deliveryCertificate;
		TechnologyPartners = technologyPartners;
		Warranty = warranty;
		ExecutionTime = executionTime;
		Notes = notes;
		Status = status;
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

}
