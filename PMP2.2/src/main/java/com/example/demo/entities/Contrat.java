package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contrat implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Contrat_ID;
	private String Title;
	private String Description;
	private Date DeliveryDate;
	public Contrat() {
		super();
	}
	public Contrat(String title, String description, Date deliveryDate) {
		super();
		Title = title;
		Description = description;
		DeliveryDate = deliveryDate;
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
