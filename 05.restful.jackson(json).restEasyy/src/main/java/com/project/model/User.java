package com.project.model;

public class User {
	private int userId;
	private String username;
	private String surname;
	public User() {
	}
	public User(int userId, String username, String surname) {
		super();
		this.userId = userId;
		this.username = username;
		this.surname = surname;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", surname=" + surname + "]";
	}
}