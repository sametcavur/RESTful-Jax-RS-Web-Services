package com.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.daoHelper.DBHelper;
import com.project.model.User;

public class UserRepository implements IUserRepository {
	DBHelper dbHelper = new DBHelper();
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultset;

	public List<User> findAllUsers() throws ClassNotFoundException {
		List<User> users = new ArrayList<User>();
		try {
			connection = dbHelper.getConnection();
			statement = connection.prepareStatement("SELECT * FROM User;");
			resultset = statement.executeQuery();
			while (resultset.next()) {
				User user = new User(resultset.getInt(1), resultset.getString(3), resultset.getString(4),
						resultset.getString(2));
				users.add(user);
			}
		} catch (SQLException e) {
			dbHelper.showErrorMessage(e);
		}
		return users;
	}

	@Override
	public User findUserById(int userId) throws ClassNotFoundException {
		User user = new User();
		try {
			connection = dbHelper.getConnection();
			statement = connection.prepareStatement("SELECT * FROM User WHERE userId=?");
			statement.setInt(1, userId);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				user = new User(resultset.getInt(1), resultset.getString(3), resultset.getString(4),
						resultset.getString(2));
			}
		} catch (SQLException e) {
			dbHelper.showErrorMessage(e);
		}
		return user;
	}

	@Override
	public void insertUser(User user) throws ClassNotFoundException {
		String insertUserQuery = "INSERT INTO user (birthOfDate, userName, userSurname) VALUES (?, ?, ?)";
		try {
			connection = dbHelper.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery);
			preparedStatement.setString(1, user.getbirthOfDate());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getUserSurname());
			preparedStatement.execute();
		} catch (SQLException e) {
			dbHelper.showErrorMessage(e);
		}
	}

	@Override
	public User updateUser(int userId,User user) throws ClassNotFoundException {
		String updateUserQuery = "UPDATE user SET birthOfDate=?, userName =?, userSurname =? WHERE userId =?";
		try {
			connection = dbHelper.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(updateUserQuery);
			preparedStatement.setString(1, user.getbirthOfDate());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getUserSurname());
			preparedStatement.setInt(4, user.getUserId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			dbHelper.showErrorMessage(e);
		}
		return user;
	}

	@Override
	public void deleteUser(int userId) throws ClassNotFoundException{
		String deleteUserQuery = "DELETE FROM User WHERE userId=?";
			try {
				connection = dbHelper.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(deleteUserQuery);
				preparedStatement.setInt(1,userId);
				preparedStatement.execute();
			}
		 catch (SQLException e) {
			dbHelper.showErrorMessage(e);
	}
}
}