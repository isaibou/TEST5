package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExternalRequest implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer ExternalRequest_ID;
	private String NameExternalRequest;
	public ExternalRequest() {
		super();
	}
	public ExternalRequest(String nameExternalRequest) {
		super();
		NameExternalRequest = nameExternalRequest;
	}
	public Integer getExternalRequest_ID() {
		return ExternalRequest_ID;
	}
	public void setExternalRequest_ID(Integer externalRequest_ID) {
		ExternalRequest_ID = externalRequest_ID;
	}
	public String getNameExternalRequest() {
		return NameExternalRequest;
	}
	public void setNameExternalRequest(String nameExternalRequest) {
		NameExternalRequest = nameExternalRequest;
	}
	
	

}
