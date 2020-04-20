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
import javax.persistence.SequenceGenerator;


import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq_id")
	@SequenceGenerator(name = "my_seq_id", sequenceName = "my_seq_id", allocationSize = 100)
	
	private Integer Customer_ID;
	
	@NotNull 
	@Column(name="Name",length=30,unique=true)
	private String Name;
	
	@NotNull
	private String Industry;
	

	private String Logo;

    
	@NotNull
	@NumberFormat(pattern = "##########")
	private String PhoneCompany;
	
	@NotNull
	private String AdressCompany;
	
	@NotNull
	private String Vip;
	
	@NotNull
	@Column(name="NomTechnical",length=30)
	private String NomTechnical;
	
	@NotNull
	@NumberFormat(pattern = "##########")
	private String PhoneTechnical;
	
	@NotNull
	@Email
	private String EmailTechnical;
	
	@NotNull
	@Column(name="NomCIO",length=30)
	private String NomCIO;
	
	@NotNull
	@NumberFormat(pattern = "##########")
	private String PhoneCIO;
	
	@NotNull
	@Email
	private String EmailCIO;

	private String City;

	private String Country;
	

	@NotNull
	private String Status;
	
	@OneToMany
	private Collection <Purchasing> Purchasing;
	
	@OneToMany
	private Collection <Contrat> contrat;

	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<Users> users;
	
	public Customer() {
		super();
	}

	
	public Customer(@NotNull String name, @NotNull String industry, String logo, @NotNull String phoneCompany,
			@NotNull String adressCompany, @NotNull String vip, @NotNull String nomTechnical,
			@NotNull String phoneTechnical, @NotNull @Email String emailTechnical, @NotNull String nomCIO,
			@NotNull String phoneCIO, @NotNull @Email String emailCIO, String city, String country,
			@NotNull String status) {


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
		Status = status;
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
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
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
}
