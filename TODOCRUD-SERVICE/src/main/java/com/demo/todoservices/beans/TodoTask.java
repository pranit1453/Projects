package com.demo.todoservices.beans;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todotable")
public class TodoTask {
	@Id
	private int taskid;
	private String title;
	private String description;
	private LocalDate createdAt;
	private boolean completed;

	public TodoTask() {
		super();
	}

	public TodoTask(int taskid, String title, String description, LocalDate createdAt, boolean completed) {
		super();
		this.taskid = taskid;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.completed = completed;
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public boolean getCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
