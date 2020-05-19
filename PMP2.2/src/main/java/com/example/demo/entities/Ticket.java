package com.example.demo.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ticket implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Ticket_ID;
	private String Description;
	private String LogFiles;
	private String SolutionDescription;
	private Date OpenedDate;
	private Date ClosedDate;
	private Date LastUpdatedate;
	private String statusTicket;
	private String PriorityTicket;
	private String TypeTicket;
	
	@ManyToOne
	@JoinColumn(name="ASSET_ID")
	private Assets asset;
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Users user;
	public Ticket() {
		super();
	}

	

	public Ticket(String description, String logFiles, String solutionDescription, Date openedDate, Date closedDate,
			Date lastUpdatedate, String StatusTicket, String priorityTicket, String typeTicket) {
		super();
		Description = description;
		LogFiles = logFiles;
		SolutionDescription = solutionDescription;
		OpenedDate = openedDate;
		ClosedDate = closedDate;
		LastUpdatedate = lastUpdatedate;
		statusTicket = StatusTicket;
		PriorityTicket = priorityTicket;
		TypeTicket = typeTicket;
	}



	public Integer getTicket_ID() {
		return Ticket_ID;
	}

	public void setTicket_ID(Integer ticket_ID) {
		Ticket_ID = ticket_ID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getLogFiles() {
		return LogFiles;
	}

	public void setLogFiles(String logFiles) {
		LogFiles = logFiles;
	}

	public String getSolutionDescription() {
		return SolutionDescription;
	}

	public void setSolutionDescription(String solutionDescription) {
		SolutionDescription = solutionDescription;
	}

	public Date getOpenedDate() {
		return OpenedDate;
	}

	public void setOpenedDate(Date openedDate) {
		OpenedDate = openedDate;
	}

	public Date getClosedDate() {
		return ClosedDate;
	}

	public void setClosedDate(Date closedDate) {
		ClosedDate = closedDate;
	}

	public Date getLastUpdatedate() {
		return LastUpdatedate;
	}

	public void setLastUpdatedate(Date lastUpdatedate) {
		LastUpdatedate = lastUpdatedate;
	}

	

	public String getPriorityTicket() {
		return PriorityTicket;
	}

	public void setPriorityTicket(String priorityTicket) {
		PriorityTicket = priorityTicket;
	}



	public String getTypeTicket() {
		return TypeTicket;
	}



	public void setTypeTicket(String typeTicket) {
		TypeTicket = typeTicket;
	}



	public Assets getAsset() {
		return asset;
	}



	public void setAsset(Assets asset) {
		this.asset = asset;
	}



	public String getStatusTicket() {
		return statusTicket;
	}



	public void setStatusTicket(String statusTicket) {
		this.statusTicket = statusTicket;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Users getUser() {
		return user;
	}



	public void setUser(Users user) {
		this.user = user;
	}



	


	


	

}
