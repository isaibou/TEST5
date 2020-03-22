package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeUserCustomer implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer TypeUserCustomer_ID;
	private String NameTypeUserCustomer;
	
	public TypeUserCustomer() {
		super();
	}
	public TypeUserCustomer(String nameTypeUserCustomer) {
		super();
		NameTypeUserCustomer = nameTypeUserCustomer;
	}
	public Integer getTypeUserCustomer_ID() {
		return TypeUserCustomer_ID;
	}
	public void setTypeUserCustomer_ID(Integer typeUserCustomer_ID) {
		TypeUserCustomer_ID = typeUserCustomer_ID;
	}
	public String getNameTypeUserCustomer() {
		return NameTypeUserCustomer;
	}
	public void setNameTypeUserCustomer(String nameTypeUserCustomer) {
		NameTypeUserCustomer = nameTypeUserCustomer;
	}

	
	
}
