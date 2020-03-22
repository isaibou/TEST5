package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InternalRequest implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer InternalRequest_ID;
	private String NameInternalRequest;
	
	public InternalRequest() {
		super();
	}

	public InternalRequest(String nameInternalRequest) {
		super();
		NameInternalRequest = nameInternalRequest;
	}

	public Integer getInternalRequest_ID() {
		return InternalRequest_ID;
	}

	public void setInternalRequest_ID(Integer internalRequest_ID) {
		InternalRequest_ID = internalRequest_ID;
	}

	public String getNameInternalRequest() {
		return NameInternalRequest;
	}

	public void setNameInternalRequest(String nameInternalRequest) {
		NameInternalRequest = nameInternalRequest;
	}

	
	
}
