package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeTicket implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer TypeTicket_ID;
	private String NameTypeTicket;
	
	
	public TypeTicket() {
		super();
	}


	public TypeTicket(String nameTypeTicket) {
		super();
		NameTypeTicket = nameTypeTicket;
	}


	public Integer getTypeTicket_ID() {
		return TypeTicket_ID;
	}


	public void setTypeTicket_ID(Integer typeTicket_ID) {
		TypeTicket_ID = typeTicket_ID;
	}


	public String getNameTypeTicket() {
		return NameTypeTicket;
	}


	public void setNameTypeTicket(String nameTypeTicket) {
		NameTypeTicket = nameTypeTicket;
	}
	

}
