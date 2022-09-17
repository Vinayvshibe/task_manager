package com.assignment.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
public class Task {
	@Id
	private Long taskId;
	private String title;
	private String description;
	private String createdBy;
	private String assignedTo;
	private String completedOn;
	private String status;
	private int time; //required time to complete task in hours
	public Task(Long taskId, String title, String description, String createdBy, String assignedTo, String completedOn,
			String status, int time) {
		super();
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.createdBy = createdBy;
		this.assignedTo = assignedTo;
		this.completedOn = completedOn;
		this.status = status;
		this.time = time;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getCompletedOn() {
		return completedOn;
	}
	public void setCompletedOn(String completedOn) {
		this.completedOn = completedOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	

}
