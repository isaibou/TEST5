package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class TypeInternalRequest implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer TypeInternalRequest_ID;
	@NotNull(message="entre  Name Type Internal Request")
	private String NameTypeInternalRequest;
	
	@OneToMany(mappedBy = "typeInternalRequest" , fetch = FetchType.LAZY)

	private Collection<InternalRequest> internal;
	
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

	public Collection<InternalRequest> getInternal() {
		return internal;
	}

	public void setInternal(Collection<InternalRequest> internal) {
		this.internal = internal;
	}


	
}
