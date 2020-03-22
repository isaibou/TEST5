package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class RFP implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer RFP_ID;
	private String Title;
	private String Description;
	private int RealaseDate;
	private Date ReponseDateTime;
	private Date NotificationDate;
	private Date RequestOfExecutionDate;
	private String RequestFile;
	private String ResponseFile;
	private String StatusRFP;
	public RFP() {
		super();
	}
	public RFP(String title, String description, int realaseDate, Date reponseDateTime, Date notificationDate,
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
	public int getRealaseDate() {
		return RealaseDate;
	}
	public void setRealaseDate(int realaseDate) {
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
