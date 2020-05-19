package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class DataCenter {
	
	@Id
	@GeneratedValue
	private Integer DataCenter_ID;
	@NotEmpty
	private String Serving ;
	@NotEmpty
	private String Adress;
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	public DataCenter() {
		super();
	}

	public DataCenter(String serving, String adress) {
		super();
		Serving = serving;
		Adress = adress;
	}

	public Integer getDataCenter_ID() {
		return DataCenter_ID;
	}

	public void setDataCenter_ID(Integer dataCenter_ID) {
		DataCenter_ID = dataCenter_ID;
	}

	public String getServing() {
		return Serving;
	}

	public void setServing(String serving) {
		Serving = serving;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	} 
	
	
	
	
	
	

}
