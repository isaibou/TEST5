package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class RFP implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer RFP_ID;
	private String Title;
	private String Description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date RealaseDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ReponseDateTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date NotificationDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date RequestOfExecutionDate;
	private String RequestFile;
	private String ResponseFile;
	private String StatusRFP;
	
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	public RFP(Customer customer) {
		super();
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
}

	public RFP() {
		super();
	}
	public RFP(String title, String description, Date realaseDate, Date reponseDateTime, Date notificationDate,
			Date requestOfExecutionDate, String requestFile, String responseFile, String statusRFP) {
		super();
		Title = title;
		Description = description;
		RealaseDate = realaseDate;
		ReponseDateTime = reponseDateTime;
		NotificationDate = notificationDate;
		RequestOfExecutionDate = requestOfExecutionDate;
		RequestFile = requestFile;
		ResponseFile = responseFile;
		StatusRFP = statusRFP;
	}
	public Integer getRFP_ID() {
		return RFP_ID;
	}
	public void setRFP_ID(Integer rFP_ID) {
		RFP_ID = rFP_ID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getRealaseDate() {
		return RealaseDate;
	}
	public void setRealaseDate(Date realaseDate) {
		RealaseDate = realaseDate;
	}
	public Date getReponseDateTime() {
		return ReponseDateTime;
	}
	public void setReponseDateTime(Date reponseDateTime) {
		ReponseDateTime = reponseDateTime;
	}
	public Date getNotificationDate() {
		return NotificationDate;
	}
	public void setNotificationDate(Date notificationDate) {
		NotificationDate = notificationDate;
	}
	public Date getRequestOfExecutionDate() {
		return RequestOfExecutionDate;
	}
	public void setRequestOfExecutionDate(Date requestOfExecutionDate) {
		RequestOfExecutionDate = requestOfExecutionDate;
	}
	public String getRequestFile() {
		return RequestFile;
	}
	public void setRequestFile(String requestFile) {
		RequestFile = requestFile;
	}
	public String getResponseFile() {
		return ResponseFile;
	}
	public void setResponseFile(String responseFile) {
		ResponseFile = responseFile;
	}
	public String getStatusRFP() {
		return StatusRFP;
	}
	public void setStatusRFP(String statusRFP) {
		StatusRFP = statusRFP;
	}
	

}
