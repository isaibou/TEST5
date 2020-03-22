package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeDeliverable implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer TypeDeliverable_ID;
	private String NameTypeDeliverable;
	
	public TypeDeliverable() {
		super();
	}

	public TypeDeliverable(String nameTypeDeliverable) {
		super();
		NameTypeDeliverable = nameTypeDeliverable;
	}

	public Integer getTypeDeliverable_ID() {
		return TypeDeliverable_ID;
	}

	public void setTypeDeliverable_ID(Integer typeDeliverable_ID) {
		TypeDeliverable_ID = typeDeliverable_ID;
	}

	public String getNameTypeDeliverable() {
		return NameTypeDeliverable;
	}

	public void setNameTypeDeliverable(String nameTypeDeliverable) {
		NameTypeDeliverable = nameTypeDeliverable;
	}
	
	

}
