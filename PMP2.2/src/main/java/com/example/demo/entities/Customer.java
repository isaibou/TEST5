package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Customer_ID;
	@Column(unique=true)
	private String Name;
	@Column(name="Industry")
	private String Industry;
	@Column(name="Logo")
	private String Logo;

	@Column(name="PhoneCompany")
	private String PhoneCompany;
	@Column(name="AdressCompany")
	private String AdressCompany;
	@Column(name="Vip")
	private String Vip;
	@Column(name="NomTechnical")
	private String NomTechnical;
	@Column(name="PhoneTechnical")
	private String PhoneTechnical;
	@Column(name="EmailTechnical")
	private String EmailTechnical;
	@Column(name="NomCIO")
	private String NomCIO;
	@Column(name="PhoneCIO")
	private String PhoneCIO;
	@Column(name="EmailCIO")
	private String EmailCIO;
	@Column(name="City")
	private String City;
	@Column(name="Country")
	private String Country; 
	@Column(name="Status")
	private String Status;
	
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

}
