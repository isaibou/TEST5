package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Vendor implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Vendor_ID;
	
	private String PartnershipCertificate;
	
	@NotEmpty
	@Column(name = "NameVendor")
	private String NameVendor;
	private String Industry;
	private String LogoCompony;
	@NotEmpty
	private String Phone;
	@NotEmpty
	private String Adress;
	private String Status;
	
	@ManyToMany
	private Collection <AssetType> assettype;
	
	
	public Collection<AssetType> getAssettype() {
		return assettype;
	}


	public void setAssettype(Collection<AssetType> assettype) {
		this.assettype = assettype;
	}


	public Vendor() {
		super();
	}


	public Vendor(String partnershipCertificate, String nameVendor, String industry, String logoCompony, String phone,
			String adress, String status) {
		super();
		PartnershipCertificate = partnershipCertificate;
		NameVendor = nameVendor;
		Industry = industry;
		LogoCompony = logoCompony;
		Phone = phone;
		Adress = adress;
		this.Status = status;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public Integer getVendor_ID() {
		return Vendor_ID;
	}


	public void setVendor_ID(Integer vendor_ID) {
		Vendor_ID = vendor_ID;
	}


	public String getPartnershipCertificate() {
		return PartnershipCertificate;
	}


	public void setPartnershipCertificate(String partnershipCertificate) {
		PartnershipCertificate = partnershipCertificate;
	}


	public String getNameVendor() {
		return NameVendor;
	}


	public void setNameVendor(String nameVendor) {
		NameVendor = nameVendor;
	}


	public String getIndustry() {
		return Industry;
	}


	public void setIndustry(String industry) {
		Industry = industry;
	}


	public String getLogoCompony() {
		return LogoCompony;
	}


	public void setLogoCompony(String logoCompony) {
		LogoCompony = logoCompony;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getAdress() {
		return Adress;
	}


	public void setAdress(String adress) {
		Adress = adress;
	}
	
	

}
