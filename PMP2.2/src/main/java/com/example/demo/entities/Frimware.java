package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Frimware implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer frimware_ID;
	
	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseDate;
	@NotEmpty
	private String description;
	private String status;
	
	
	@ManyToMany
	@JoinTable(name="ASSETTYPE_FIRMWARE")
	private Collection<AssetType> assetType;
	
	@OneToMany(mappedBy = "frimware")
	private Collection<Assets> assets;

	public Frimware() {
		super();

		//this.releaseDate = new Date();
	}
	



	public Frimware(Integer frimware_ID, String name, Date releaseDate, String description, String status) {
		super();
		this.frimware_ID = frimware_ID;
		this.name = name;
		this.releaseDate = releaseDate;
		this.description = description;
		this.status = status;
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
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public Collection<AssetType> getAssetType() {
		return assetType;
	}




	public void setAssetType(Collection<AssetType> assetType) {
		this.assetType = assetType;
	}




	public Collection<Assets> getAssets() {
		return assets;
	}




	public void setAssets(Collection<Assets> assets) {
		this.assets = assets;
	}



}
