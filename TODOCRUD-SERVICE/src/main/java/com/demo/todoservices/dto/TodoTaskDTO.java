package com.demo.todoservices.dto;

public class TodoTaskDTO {
	private String taskid;
	private String title;
	private String description;
	private String createdAt;
	private String completed;

	public TodoTaskDTO() {
		super();
	}

	public TodoTaskDTO(String taskid, String title, String description, String createdAt, String completed) {
		super();
		this.taskid = taskid;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.completed = completed;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

}
