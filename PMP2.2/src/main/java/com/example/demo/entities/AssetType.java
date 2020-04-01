package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class AssetType implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer AssetType_ID;
	
	private String Name;
	private String Brand;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date EndOfSuportDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date EndSaleDate;
	private String FRU;
	private String Status;
	
	public AssetType() {
		super();
	}

	public AssetType(String Name, String brand, Date endOfSuportDate, Date endSaleDate, String fRU, String status) {
		super();
		this.AssetType_ID = AssetType_ID;
		this.Name = Name;
		this.Brand = brand;
		this.EndOfSuportDate = endOfSuportDate;
		this.EndSaleDate = endSaleDate;
		this.FRU = fRU;
		this.Status = status;
	}

	public Integer getAssetType_ID() {
		return AssetType_ID;
	}

	public void setAssetType_ID(Integer assetType_ID) {
		AssetType_ID = assetType_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public Date getEndOfSuportDate() {
		return EndOfSuportDate;
	}

	public void setEndOfSuportDate(Date endOfSuportDate) {
		EndOfSuportDate = endOfSuportDate;
	}

	public Date getEndSaleDate() {
		return EndSaleDate;
	}

	public void setEndSaleDate(Date endSaleDate) {
		EndSaleDate = endSaleDate;
	}

	public String getFRU() {
		return FRU;
	}

	public void setFRU(String fRU) {
		FRU = fRU;
	}
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	

	
}
