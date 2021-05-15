package com.project.repository;

import java.util.List;

import com.project.model.User;

public interface IUserRepository {
	public List<User> findAllUsers() throws ClassNotFoundException;
	public User findUserById(int userId) throws ClassNotFoundException;
	public void insertUser(User user) throws ClassNotFoundException;
	public User updateUser(int userId,User user) throws ClassNotFoundException;
	public void deleteUser(int userId) throws ClassNotFoundException;
}
