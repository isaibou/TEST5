package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Assets implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Assets_ID;
	private String SerielNumber;
	private String Description;
	private String ConfigurationFille;
	private String MustGather;
	private String EndOfVendorWarranty;
	private Date EndPowermWarranty;
	private String SLA;
	private String InterfaceAasset;
	private String LoginAsset;
	private int PasswordAsset;
	private Date LastUpdate;
	
	
	public Assets() {
		super();
	}
	
	public Assets(String serielNumber, String description, String configurationFille, String mustGather,
			String endOfVendorWarranty, Date endPowermWarranty, String sLA, String interfaceAasset, String loginAsset,
			int passwordAsset, Date lastUpdate) {
		super();
		SerielNumber = serielNumber;
		Description = description;
		ConfigurationFille = configurationFille;
		MustGather = mustGather;
		EndOfVendorWarranty = endOfVendorWarranty;
		EndPowermWarranty = endPowermWarranty;
		SLA = sLA;
		InterfaceAasset = interfaceAasset;
		LoginAsset = loginAsset;
		PasswordAsset = passwordAsset;
		LastUpdate = lastUpdate;
	}
	
	public Integer getAssets_ID() {
		return Assets_ID;
	}
	
	public void setAssets_ID(Integer assets_ID) {
		Assets_ID = assets_ID;
	}
	
	public String getSerielNumber() {
		return SerielNumber;
	}
	
	public void setSerielNumber(String serielNumber) {
		SerielNumber = serielNumber;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	public String getConfigurationFille() {
		return ConfigurationFille;
	}
	
	public void setConfigurationFille(String configurationFille) {
		ConfigurationFille = configurationFille;
	}
	
	public String getMustGather() {
		return MustGather;
	}
	
	public void setMustGather(String mustGather) {
		MustGather = mustGather;
	}
	
	public String getEndOfVendorWarranty() {
		return EndOfVendorWarranty;
	}
	
	public void setEndOfVendorWarranty(String endOfVendorWarranty) {
		EndOfVendorWarranty = endOfVendorWarranty;
	}
	public Date getEndPowermWarranty() {
		return EndPowermWarranty;
	}
	public void setEndPowermWarranty(Date endPowermWarranty) {
		EndPowermWarranty = endPowermWarranty;
	}
	public String getSLA() {
		return SLA;
	}
	public void setSLA(String sLA) {
		SLA = sLA;
	}
	public String getInterfaceAasset() {
		return InterfaceAasset;
	}
	public void setInterfaceAasset(String interfaceAasset) {
		InterfaceAasset = interfaceAasset;
	}
	public String getLoginAsset() {
		return LoginAsset;
	}
	public void setLoginAsset(String loginAsset) {
		LoginAsset = loginAsset;
	}
	public int getPasswordAsset() {
		return PasswordAsset;
	}
	public void setPasswordAsset(int passwordAsset) {
		PasswordAsset = passwordAsset;
	}
	public Date getLastUpdate() {
		return LastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		LastUpdate = lastUpdate;
	}
	
	

}
