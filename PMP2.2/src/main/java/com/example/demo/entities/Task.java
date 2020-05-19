package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.demo.controllers.TicketsController;


@Entity
public class Task implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer task_ID;
	private String taskDescription;
	private Date dateTime;
	private int roadTime;
	private int percentComplete;
	
	@OneToMany(mappedBy = "task" , fetch = FetchType.LAZY)
	private Collection<Expenses> expenses;
	
	@ManyToOne
	@JoinColumn(name = "USERS_ID")
	private Users users;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="TICKET_ID")
	private Ticket ticket;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="AFFETATIONPROJECT_ID")
	private AffectationProject affectationProject;
	
	
	public Task() {
		super();
	}
	public Integer getTask_ID() {
		return task_ID;
	}
	public void setTask_ID(Integer task_ID) {
		this.task_ID = task_ID;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getRoadTime() {
		return roadTime;
	}
	public void setRoadTime(int roadTime) {
		this.roadTime = roadTime;
	}
	public int getPercentComplete() {
		return percentComplete;
	}
	public void setPercentComplete(int percentComplete) {
		this.percentComplete = percentComplete;
	}
	public Collection<Expenses> getExpenses() {
		return expenses;
	}
	public void setExpenses(Collection<Expenses> expenses) {
		this.expenses = expenses;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public AffectationProject getAffectationProject() {
		return affectationProject;
	}
	public void setAffectationProject(AffectationProject affectationProject) {
		this.affectationProject = affectationProject;
	}

	
	
}
