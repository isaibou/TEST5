package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeExpenses {
	@Id
	@GeneratedValue
	private Integer TypeExpenses_ID; 
	private String NameTypeExpenses;
	
	
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
