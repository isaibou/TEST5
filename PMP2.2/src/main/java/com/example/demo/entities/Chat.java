package com.example.demo.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chat implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Message_ID;
	private String Description;
	private Date Date;
	private String UploadFile;
	
	public Chat() {
		super();
	}

	public Chat(String description, java.util.Date date, String uploadFile) {
		super();
		Description = description;
		Date = date;
		UploadFile = uploadFile;
	}

	public Integer getMessage_ID() {
		return Message_ID;
	}

	public void setMessage_ID(Integer message_ID) {
		Message_ID = message_ID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getUploadFile() {
		return UploadFile;
	}

	public void setUploadFile(String uploadFile) {
		UploadFile = uploadFile;
	}
	
	

}
