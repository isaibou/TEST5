package com.example.demo.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class TypeExpenses {
	
	@Id
	@GeneratedValue
	private Integer TypeExpenses_ID; 
	
	@NotEmpty
	private String NameTypeExpenses;
	
	@OneToMany(mappedBy = "typeExpenses", fetch = FetchType.LAZY)
	private Collection<Expenses> expenses; 
	
	
	public TypeExpenses() {
		super();
	}
	
	public TypeExpenses(String nameTypeExpenses) {
		super();
		NameTypeExpenses = nameTypeExpenses;
	}

	public Integer getTypeExpenses_ID() {
		return TypeExpenses_ID;
	}

	public void setTypeExpenses_ID(Integer typeExpenses_ID) {
		TypeExpenses_ID = typeExpenses_ID;
	}

	public String getNameTypeExpenses() {
		return NameTypeExpenses;
	}

	public void setNameTypeExpenses(String nameTypeExpenses) {
		NameTypeExpenses = nameTypeExpenses;
	} 
	
	
	
	
	
	

}
