package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DataCenter {
	
	
	@Id
	@GeneratedValue
	private Integer DataCenter_ID;
	private String Serving ;
	private String Adress;
	
	public DataCenter() {
		super();
	}

	public DataCenter(String serving, String adress) {
		super();
		Serving = serving;
		Adress = adress;
	}

	public Integer getDataCenter_ID() {
		return DataCenter_ID;
	}

	public void setDataCenter_ID(Integer dataCenter_ID) {
		DataCenter_ID = dataCenter_ID;
	}

	public String getServing() {
		return Serving;
	}

	public void setServing(String serving) {
		Serving = serving;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	} 
	
	
	
	
	
	

}
