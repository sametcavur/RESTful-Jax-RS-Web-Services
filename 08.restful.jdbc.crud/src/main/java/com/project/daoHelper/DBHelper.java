package com.project.daoHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/jpa";
		String ıd="root";
		String pass="1234";
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, ıd, pass);
		
	}

	public void showErrorMessage(SQLException e) {
		System.out.println("SQL Hatası:" + e.getLocalizedMessage());
		System.out.println("Hata Kodu:" + e.getErrorCode());
	}

}
