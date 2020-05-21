package com.example.demo.entities;

import java.io.Serializable;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Customer implements Serializable{
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq_id")	
	@SequenceGenerator(name = "my_seq_id", sequenceName = "my_seq_id", allocationSize = 100)
	private Integer Customer_ID;
	
	@NotEmpty
	@Column(name="Name",length=30)
	private String Name;
	
	@NotEmpty
	private String Industry;
	
	private String Logo;

	@NotEmpty
	@NumberFormat(pattern = "##########")
	private String PhoneCompany;
	
	@NotEmpty
	private String AdressCompany;
	
	@NotEmpty
	private String Vip;
	
	@NotEmpty
	@Column(name="NomTechnical",length=30)
	private String NomTechnical;
	
	@NotEmpty
	@NumberFormat(pattern = "##########")
	private String PhoneTechnical;
	
	@NotEmpty
	@Email(message="Email invalid")
	private String EmailTechnical;
	
	@NotEmpty
	@Column(name="NomCIO",length=30)
	private String NomCIO;
	
	@NotEmpty
	@NumberFormat(pattern = "##########")
	private String PhoneCIO;
	
	@NotEmpty
	@Email(message="Email invalid")
	private String EmailCIO;

	private String City;

	private String Country;
	
	private String status;
	
	@OneToMany
	private Collection <Purchasing> Purchasing;
	
	@OneToMany
	private Collection <Contrat> contrat;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<Users> users;
	
	@OneToMany(mappedBy = "customer" , fetch = FetchType.LAZY)
	private Collection<DataCenter> dataCenter;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<Assets> assets;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<RFP> rfp;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<Ticket> tickets;
	
	public Customer() {
		super();
	}

	public Customer(String name, String industry, String logo, String phoneCompany, String adressCompany, String vip, 
			String nomCIO, String phoneCIO, String emailCIO, String nomTechnical, String emailTechnical, String phoneTechnical, String city, String country, String status) {
		super();
		Name = name;
		Industry = industry;
		Logo = logo;
		PhoneCompany = phoneCompany;
		AdressCompany = adressCompany;
		Vip = vip;
		
		NomTechnical = nomTechnical;
		PhoneTechnical = phoneTechnical;
		EmailTechnical = emailTechnical;
		NomCIO = nomCIO;
		NomCIO= nomCIO;
		PhoneCIO = phoneCIO;
		EmailCIO = emailCIO;
		City = city;
		Country = country;
		status = status;
	}

	public Integer getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(Integer customer_ID) {
		Customer_ID = customer_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getIndustry() {
		return Industry;
	}

	public void setIndustry(String industry) {
		Industry = industry;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getLogo() {
		return Logo;
	}

	public void setLogo(String logo) {
		Logo = logo;
	}

	public String getPhoneCompany() {
		return PhoneCompany;
	}

	public void setPhoneCompany(String phoneCompany) {
		PhoneCompany = phoneCompany;
	}

	public String getAdressCompany() {
		return AdressCompany;
	}

	public void setAdressCompany(String adressCompany) {
		AdressCompany = adressCompany;
	}

	public String getVip() {
		return Vip;
	}

	public void setVip(String vip) {
		Vip = vip;
	}

	public String getPhoneCIO() {
		return PhoneCIO;
	}

	public void setPhoneCIO(String phoneCIO) {
		PhoneCIO = phoneCIO;
	}

	public String getEmailCIO() {
		return EmailCIO;
	}

	public void setEmailCIO(String emailCIO) {
		EmailCIO = emailCIO;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		status = status;
	}

	public String getNomCIO() {
		return NomCIO;
	}

	public void setNomCIO(String nomCIO) {
		NomCIO = nomCIO;
	}

	public String getNomTechnical() {
		return NomTechnical;
	}

	public void setNomTechnical(String nomTechnical) {
		NomTechnical = nomTechnical;
	}

	public String getPhoneTechnical() {
		return PhoneTechnical;
	}

	public void setPhoneTechnical(String phoneTechnical) {
		PhoneTechnical = phoneTechnical;
	}

	public String getEmailTechnical() {
		return EmailTechnical;
	}

	public void setEmailTechnical(String emailTechnical) {
		EmailTechnical = emailTechnical;
	}

	public Collection<Users> getUsers() {
		return users;
	}

	public void setUsers(Collection<Users> users) {
		this.users = users;
	}

	public Collection<Contrat> getContrat() {
		return contrat;
	}

	public void setContrat(Collection<Contrat> contrat) {
		this.contrat = contrat;
	}

	public Collection<Purchasing> getPurchasing() {
		return Purchasing;
	}

	public void setPurchasing(Collection<Purchasing> purchasing) {
		Purchasing = purchasing;
	}

	public Collection<DataCenter> getDataCenter() {
		return dataCenter;
	}

	public void setDataCenter(Collection<DataCenter> dataCenter) {
		this.dataCenter = dataCenter;
	}

	public Collection<Assets> getAssets() {
		return assets;
	}

	public void setAssets(Collection<Assets> assets) {
		this.assets = assets;
	}

	public Collection<RFP> getRfp() {
		return rfp;
	}

	public void setRfp(Collection<RFP> rfp) {
		this.rfp = rfp;
	}

	public Collection<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Collection<Ticket> tickets) {
		this.tickets = tickets;
	}

	/*public Object size() {
		// TODO Auto-generated method stub
		return Status;
	}*/
		
}
