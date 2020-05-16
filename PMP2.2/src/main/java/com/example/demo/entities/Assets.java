package com.example.demo.entities;

import java.io.Serializable;


import java.util.Collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Assets implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Assets_ID;

	
	@NotEmpty
	@Column (name="SerielNumber",unique=true)

	private String SerielNumber;
	
	@NotEmpty
	private String Description;
	private String ConfigurationFille;
	
	@NotEmpty
	private String MustGather;
	
	@DateTimeFormat(pattern =  "yyyy-MM-dd")
	private String EndOfVendorWarranty;
	
	@DateTimeFormat(pattern =  "yyyy-MM-dd")
	private Date EndPowermWarranty;
	
	private String SLA;
	@NotEmpty
	private String InterfaceAasset;
	private String LoginAsset;
	private int PasswordAsset;
	private Date LastUpdate;
	private String Status;
	
	
	@ManyToOne
	@JoinColumn
	private AssetType assettype;
	

	@ManyToMany
	@JoinTable(name="ASSET_PROJECT")
	private Collection<Project> project;
	
	@ManyToOne

	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="FRIMWARE_ID")
	private Frimware frimware ;
	
	@OneToMany(mappedBy = "asset" , fetch = FetchType.LAZY)
	private Collection<Ticket> ticket;
	
	// a supprimer 
	//@ManyToOne
	//@JoinColumn
	//private Frimware frimware;
	
	
	//public Frimware getFrimware() {
		//return frimware;
	//}



	/*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Frimware> frimwares = new ArrayList<>();
	

	
<<<<<<< HEAD
=======
	public List<Frimware> getFrimwares() {
		return frimwares;
	}

	public void setFrimwares(List<Frimware> frimwares) {
		this.frimwares = frimwares;
	}*/
	
	
	
	public Assets(AssetType assettype) {
		super();
		this.assettype = assettype;
	}
	
	//attribut customer de type Customer 
	//private Customer customer;
	//private Project project;
	
	
	public AssetType getAssettype() {
		return assettype;
	}

	public void setAssettype(AssetType assettype) {
		this.assettype = assettype;
	}

	
	
	public Assets() {
		super();
	}
	
	public Assets(String serielNumber, String description, String configurationFille, String mustGather,
			String endOfVendorWarranty, Date endPowermWarranty, String sLA, String interfaceAasset, String loginAsset,
			int passwordAsset, Date lastUpdate, String status) {
		super();
		SerielNumber = serielNumber;
		//AssetsName = assetsName;
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
		this.Status = status;
	}
	
	//public String getAssetsName() {
		//return AssetsName;
//	}

	//public void setAssetsName(String assetsName) {
		//AssetsName = assetsName;
	//}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Frimware getFrimware() {
		return frimware;
	}

	public void setFrimware(Frimware frimware) {
		this.frimware = frimware;
	}

	public Collection<Project> getProject() {
		return project;
	}

	public void setProject(Collection<Project> project) {
		this.project = project;
	}

	public Collection<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Collection<Ticket> ticket) {
		this.ticket = ticket;
	}

	

	

}
