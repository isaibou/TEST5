package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Frimware implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Frimware_ID;
	private Date ReleaseDate;
	private String Description;
	
	public Frimware() {
		super();
	}
	

	public Frimware(Date releaseDate, String description) {
		super();
		ReleaseDate = releaseDate;
		Description = description;
	}


	public Integer getFrimware_ID() {
		return Frimware_ID;
	}


	public void setFrimware_ID(Integer frimware_ID) {
		Frimware_ID = frimware_ID;
	}


	public Date getReleaseDate() {
		return ReleaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}
	
	
	

}
