package com.demo.beans;

public class Users {
	private int userid;
	private String username;
	private String password;
	private String contact;
	private String gender;
	private String role;

	public Users() {
		super();
	}

	public Users(int userid, String username, String password, String contact, String gender, String role) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.contact = contact;
		this.gender = gender;
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
