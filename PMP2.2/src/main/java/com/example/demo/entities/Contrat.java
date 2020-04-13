package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Contrat implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Contrat_ID;
	@NotNull 
	@Column(unique=true)
	private String Title;
	private String Description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DeliveryDate;
	//les relation avec customer
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Integer getContrat_ID() {
		return Contrat_ID;
	}


	public Contrat(Customer customer) {
		super();
		this.customer = customer;
	}
	
	
	public Contrat() {
		super();
	}
	public Contrat(String title, String description, Date deliveryDate) {
		super();
		this.Contrat_ID = Contrat_ID;
		this.Title = title;
		this.Description = description;
		this.DeliveryDate = deliveryDate;
	}
	public Integer getContract_ID() {
		return Contrat_ID;
	}
	public void setContrat_ID(Integer contrat_ID) {
		Contrat_ID = contrat_ID;
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
	public Date getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	
	

}
