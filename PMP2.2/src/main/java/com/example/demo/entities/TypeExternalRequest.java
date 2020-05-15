package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class TypeExternalRequest implements Serializable{
	@Id
	@GeneratedValue
	private Integer TypeExternelRequest_ID;
	@NotNull(message="entre Name Type Externel Request")
	private String NameTypeExternelRequest;
	
	@OneToMany(mappedBy = "typeExternalRequest", fetch = FetchType.LAZY)
	private Collection<ExternalRequest> externalrequest;
	
	public TypeExternalRequest() {
		super();
	}

	public TypeExternalRequest(String nameTypeExternelRequest) {
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

	public Collection<ExternalRequest> getExternalrequest() {
		return externalrequest;
	}

	public void setExternalrequest(Collection<ExternalRequest> externalrequest) {
		this.externalrequest = externalrequest;
	}
	

	
}
