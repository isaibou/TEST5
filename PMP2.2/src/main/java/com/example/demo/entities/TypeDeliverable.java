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
public class TypeDeliverable implements Serializable{
	
	
	@Id
	@GeneratedValue
	private Integer TypeDeliverable_ID;
	@NotNull(message="entre Name Type Deliverable")
	private String NameTypeDeliverable;
	
	@OneToMany(mappedBy = "typeDeliverable", fetch = FetchType.LAZY)
	private Collection<Deliverable> deliverable;
	
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

	public Collection<Deliverable> getDeliverable() {
		return deliverable;
	}

	public void setDeliverable(Collection<Deliverable> deliverable) {
		this.deliverable = deliverable;
	}
	
	

}
