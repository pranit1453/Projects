package com.demo.beans;

import java.sql.Timestamp;

public class Todos {
	private int id;
	private int user_id;
	private String title;
	private String description;
	private boolean completed;
	private Timestamp createdAt;

	public Todos() {
		super();
	}

	public Todos(int id, int user_id, String title, String description, boolean completed, Timestamp createdAt) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public boolean getCompleted() {
		return completed;
	}

	public void setCompleted(boolean is_completed) {
		this.completed = is_completed;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}
