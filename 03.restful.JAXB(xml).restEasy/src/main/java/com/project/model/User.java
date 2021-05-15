package com.project.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	@XmlElement(name = "ıd")
	private int userId;
	@XmlElement(name ="uname")
	private String username;
	@XmlElement(name = "sname")
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