package com.example.demo.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private String StatusTicket;
	private String PriorityTicket;
	private String TypeTicket;
	@OneToOne
	@JoinColumn
	private Ticket ticket;
	
	public Ticket() {
		super();
	}

	

	public Ticket(String description, String logFiles, String solutionDescription, Date openedDate, Date closedDate,
			Date lastUpdatedate, String statusTicket, String priorityTicket, String typeTicket) {
		super();
		Description = description;
		LogFiles = logFiles;
		SolutionDescription = solutionDescription;
		OpenedDate = openedDate;
		ClosedDate = closedDate;
		LastUpdatedate = lastUpdatedate;
		StatusTicket = statusTicket;
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

	public String getStatusTicket() {
		return StatusTicket;
	}

	public void setStatusTicket(String statusTicket) {
		StatusTicket = statusTicket;
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



	public Ticket getTicket() {
		return ticket;
	}



	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	

}
