package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Frimware implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer frimware_ID;
	@NotEmpty
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseDate;
	private String description;
	private String Status;
	
	public Frimware() {
		super();

		//this.releaseDate = new Date();
	}
	
	

	public Frimware(Date releaseDate, String name, String description, String status) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.description = description;
		this.Status = status;
	}



	public Frimware(Integer frimware_ID, String name, Date releaseDate, String description, String status) {
		super();
		this.frimware_ID = frimware_ID;
		this.name = name;
		this.releaseDate = releaseDate;
		this.description = description;
		this.Status = status;
	}



	public Integer getFrimware_ID() {
		return frimware_ID;
	}

	public void setFrimware_ID(Integer frimware_ID) {
		this.frimware_ID = frimware_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}


}
