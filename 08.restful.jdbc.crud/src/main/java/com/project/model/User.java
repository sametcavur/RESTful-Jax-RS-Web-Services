package com.project.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.NONE)
public class User {
	@XmlElement
	private int userId;
	@XmlElement
	private String userName;
	@XmlElement
	private String userSurname;
	@XmlElement
	private String birthOfDate;
	public User() {
	}
	public User(int userId, String userName, String userSurname,String birthOfDate) {
		this.userId = userId;
		this.userName = userName;
		this.userSurname = userSurname;
		this.birthOfDate = birthOfDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public String getbirthOfDate() {
		return birthOfDate;
	}
	public void setbirthOfDate(String birthOfDate) {
		this.birthOfDate = birthOfDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSurname=" + userSurname + ", birthOfDate="
				+ birthOfDate + "]";
	}
}
