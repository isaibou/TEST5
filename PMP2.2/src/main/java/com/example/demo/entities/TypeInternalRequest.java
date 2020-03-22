package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeInternalRequest implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer TypeInternalRequest_ID;
	private String NameTypeInternalRequest;
	
	public TypeInternalRequest() {
		super();
	}

	public TypeInternalRequest(String nameTypeInternalRequest) {
		super();
		NameTypeInternalRequest = nameTypeInternalRequest;
	}

	public Integer getTypeInternalRequest_ID() {
		return TypeInternalRequest_ID;
	}

	public void setTypeInternalRequest_ID(Integer typeInternalRequest_ID) {
		TypeInternalRequest_ID = typeInternalRequest_ID;
	}

	public String getNameTypeInternalRequest() {
		return NameTypeInternalRequest;
	}

	public void setNameTypeInternalRequest(String nameTypeInternalRequest) {
		NameTypeInternalRequest = nameTypeInternalRequest;
	}


	
}
