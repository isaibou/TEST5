package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeExternelRequest implements Serializable{
	@Id
	@GeneratedValue
	private Integer TypeExternelRequest_ID;
	private String NameTypeExternelRequest;
	
	public TypeExternelRequest() {
		super();
	}

	public TypeExternelRequest(String nameTypeExternelRequest) {
		super();
		NameTypeExternelRequest = nameTypeExternelRequest;
	}

	public Integer getTypeExternelRequest_ID() {
		return TypeExternelRequest_ID;
	}

	public void setTypeExternelRequest_ID(Integer typeExternelRequest_ID) {
		TypeExternelRequest_ID = typeExternelRequest_ID;
	}

	public String getNameTypeExternelRequest() {
		return NameTypeExternelRequest;
	}

	public void setNameTypeExternelRequest(String nameTypeExternelRequest) {
		NameTypeExternelRequest = nameTypeExternelRequest;
	}
	

	
}
