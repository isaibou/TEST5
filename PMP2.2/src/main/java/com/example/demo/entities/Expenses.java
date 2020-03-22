package com.example.demo.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expenses implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Expenses_ID;
	private Double Amount;
	private String Description;
	private String Receipt;
	private Date SubmittedDate;
	private String StatutExpense;
	private String RejectReason;
	
	
	public Expenses() {
		super();
	}


	public Expenses(Double amount, String description, String receipt, Date submittedDate, String statutExpense,
			String rejectReason) {
		super();
		Amount = amount;
		Description = description;
		Receipt = receipt;
		SubmittedDate = submittedDate;
		StatutExpense = statutExpense;
		RejectReason = rejectReason;
	}


	public Integer getExpenses_ID() {
		return Expenses_ID;
	}


	public void setExpenses_ID(Integer expenses_ID) {
		Expenses_ID = expenses_ID;
	}


	public Double getAmount() {
		return Amount;
	}


	public void setAmount(Double amount) {
		Amount = amount;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getReceipt() {
		return Receipt;
	}


	public void setReceipt(String receipt) {
		Receipt = receipt;
	}


	public Date getSubmittedDate() {
		return SubmittedDate;
	}


	public void setSubmittedDate(Date submittedDate) {
		SubmittedDate = submittedDate;
	}


	public String getStatutExpense() {
		return StatutExpense;
	}


	public void setStatutExpense(String statutExpense) {
		StatutExpense = statutExpense;
	}


	public String getRejectReason() {
		return RejectReason;
	}


	public void setRejectReason(String rejectReason) {
		RejectReason = rejectReason;
	}
	
	

}