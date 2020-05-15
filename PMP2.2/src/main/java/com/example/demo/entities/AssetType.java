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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class AssetType implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer AssetType_ID;
	
	@NotEmpty
	@Column(name = "Name",unique=true)
	private String Name;
	@Column(name = "Brand")
	private String Brand;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date EndOfSuportDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date EndSaleDate;
	@NotEmpty
	@Column(name = "FRU")
	private String FRU;
	@Column(name = "Status")
	private String Status;
	
	@OneToMany
	private Collection <Assets> assets;
	
	
	public Collection<Assets> getAssets() {
		return assets;
	}

	public void setAssets(Collection<Assets> assets) {
		this.assets = assets;
	}

	
	@ManyToMany(mappedBy = "assetType")
	private List<Frimware> frimware;

	@ManyToMany
	private Collection <Vendor> Vendor;
	

	public List<Frimware> getFrimware() {
		return frimware;
	}

	public void setFrimware(List<Frimware> frimware) {
		this.frimware = frimware;
	}

	public Collection<Vendor> getVendor() {
		return Vendor;
	}

	public void setVendor(Collection<Vendor> vendor) {
		Vendor = vendor;
	}

	

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
