package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Task implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Task_ID;
	private String TaskDescription;
	private Date DateTime;
	private int RoadTime;
	private int PercentComple;
	public Task() {
		super();
	}
	public Task(String taskDescription, Date dateTime, int roadTime, int percentComple) {
		super();
		TaskDescription = taskDescription;
		DateTime = dateTime;
		RoadTime = roadTime;
		PercentComple = percentComple;
	}
	public Integer getTask_ID() {
		return Task_ID;
	}
	public void setTask_ID(Integer task_ID) {
		Task_ID = task_ID;
	}
	public String getTaskDescription() {
		return TaskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		TaskDescription = taskDescription;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	public int getRoadTime() {
		return RoadTime;
	}
	public void setRoadTime(int roadTime) {
		RoadTime = roadTime;
	}
	public int getPercentComple() {
		return PercentComple;
	}
	public void setPercentComple(int percentComple) {
		PercentComple = percentComple;
	}
	
	

}
