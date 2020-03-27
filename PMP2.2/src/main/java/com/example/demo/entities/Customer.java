package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer implements Serializable{
	
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

	@Id
	@GeneratedValue
	private Integer Customer_ID;
	@javax.validation.constraints.NotEmpty
	private String Name;
	private String Industry;
	private String Logo;
	private String PhoneCompany;
	private String AdressCompany;
	private Boolean Vip;
	private String PhoneCIO;
	@Email
	private String EmailCIO;
	private String City;
	private String Country; 
	
	public Customer() {
		super();
	}

	

	public Customer(String name, String industry, String logo, String phoneCompany, String adressCompany, Boolean vip,
			String phoneCIO, String emailCIO, String city, String country) {
		super();
		Name = name;
		Industry = industry;
		Logo = logo;
		PhoneCompany = phoneCompany;
		AdressCompany = adressCompany;
		Vip = vip;
		PhoneCIO = phoneCIO;
		EmailCIO = emailCIO;
		City = city;
		Country = country;
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

	public Boolean getVip() {
		return Vip;
	}

	public void setVip(Boolean vip) {
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
	
	

}
