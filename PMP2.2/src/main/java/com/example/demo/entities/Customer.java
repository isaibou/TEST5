package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Customer_ID;
	
	@NotNull 
	@Column(name="Name",length=30,unique=true)
	private String Name;
	
	@NotNull
	private String Industry;
	

	private String Logo;

    

	@NotNull
	private String PhoneCompany;
	
	@NotNull
	private String AdressCompany;
	
	@NotNull
	private String Vip;
	
	@NotNull
	@Column(name="NomTechnical")
	private String NomTechnical;
	
	@NotNull
	private String PhoneTechnical;
	
	@NotNull
	@Email
	private String EmailTechnical;
	
	@NotNull
	@Column(name="NomCIO")
	private String NomCIO;
	
	@NotNull
	private String PhoneCIO;
	
	@NotNull
	@Email
	private String EmailCIO;
	
	@NotNull
	private String City;
	
	@NotNull
	private String Country;
	
	@NotNull
	private String DataCenter;
	
	@NotNull
	private String Status;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<Users> users;
	
	public Customer() {
		super();
	}

	public Customer(String name, String industry, String logo, String phoneCompany, String adressCompany, String vip, String dataCenter,
			String nomCIO, String phoneCIO, String emailCIO, String nomTechnical, String emailTechnical, String phoneTechnical, String city, String country, String status) {
		super();
		Name = name;
		Industry = industry;
		Logo = logo;
		PhoneCompany = phoneCompany;
		AdressCompany = adressCompany;
		Vip = vip;
		DataCenter= dataCenter;
		NomCIO= nomCIO;
		PhoneCIO = phoneCIO;
		EmailCIO = emailCIO;
		NomTechnical= nomTechnical;
		EmailTechnical= emailTechnical;
		PhoneTechnical= phoneTechnical;
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
	
	public void setDataCenter(String dataCenter) {
		DataCenter = dataCenter;
	}

	public String getDataCenter() {
		return DataCenter;
	}

	public Collection<Users> getUsers() {
		return users;
	}

	public void setUsers(Collection<Users> users) {
		this.users = users;
	}

	
}
