package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeEmployee implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer TypeEmployee_ID;
	private String NameTypeEmployee;
	
	
	public TypeEmployee() {
		super();
	}


	public TypeEmployee(String nameTypeEmployee) {
		super();
		NameTypeEmployee = nameTypeEmployee;
	}


	public Integer getTypeEmployee_ID() {
		return TypeEmployee_ID;
	}


	public void setTypeEmployee_ID(Integer typeEmployee_ID) {
		TypeEmployee_ID = typeEmployee_ID;
	}


	public String getNameTypeEmployee() {
		return NameTypeEmployee;
	}


	public void setNameTypeEmployee(String nameTypeEmployee) {
		NameTypeEmployee = nameTypeEmployee;
	}
	

	
}
