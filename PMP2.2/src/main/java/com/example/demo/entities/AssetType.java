package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class AssetType implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer AssetType_ID;
	private String Name;
	private String Brand;
	private Date EndOfSuportDate;
	private Date EndSaleDate;
	private String FRU;
	
	public AssetType() {
		super();
	}

	public AssetType(String name, String brand, Date endOfSuportDate, Date endSaleDate, String fRU) {
		super();
		Name = name;
		Brand = brand;
		EndOfSuportDate = endOfSuportDate;
		EndSaleDate = endSaleDate;
		FRU = fRU;
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

	public void setName(String name) {
		Name = name;
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
	

	
}
