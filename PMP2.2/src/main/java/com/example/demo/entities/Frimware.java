package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Frimware implements Serializable{
	
	
	public String gFrimwareName() {
		return FrimwareName;
	}


	public void setFrimwareName(String frimwareName) {
		FrimwareName = frimwareName;
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
	
	
	@Id
	@GeneratedValue
	private Integer Frimware_ID;
	private String FrimwareName;
	@DateTimeFormat(pattern = "MM/DD/YYYY")
	private Date ReleaseDate;
	private String Description;
	
	public Frimware() {
		super();
	}
	

	public Frimware(Date releaseDate, String description, String frimwarename) {
		super();
		ReleaseDate = releaseDate;
		Description = description;
		FrimwareName = frimwarename;
	}


	public Integer getFrimware_ID() {
		return Frimware_ID;
	}


	public void setFrimware_ID(Integer frimware_ID) {
		Frimware_ID = frimware_ID;
	}

	
	
	
	
	

}
