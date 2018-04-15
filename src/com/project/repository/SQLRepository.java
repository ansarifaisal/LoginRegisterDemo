package com.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLRepository {

	Connection connection;

	public SQLRepository(Connection connection) {
		this.connection = connection;
	}

	public boolean insertRegister(String username, String password) {
		String sqlQuery = "INSERT INTO " + "REGISTER_USER(USER_NAME, PASSWORD, IS_FIRST_LOGIN) " + "VALUES (?,?,?)";
		boolean flag = false;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setBoolean(3, false);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			flag = false;
			System.out.print("Oops! SQL Error: -> ");
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public ResultSet doLogin(String username, String password) {
		String sqlQuery = "SELECT * FROM REGISTER_USER WHERE USER_NAME = ? AND PASSWORD = ?";
		ResultSet resultSet = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.print("Oops! SQL Error: -> ");
			System.out.println(e.getMessage());
		}
		return resultSet;
	}

	public boolean resetPassword(String username, String oldPassword, String newPassword) {
		if (!isEligible(username, oldPassword))
			return false;
		else {
			if (!updatePassword(username, newPassword))
				return false;
		}
		return true;
	}

	public boolean updatePassword(String username, String password) {
		String sqlQuery = "UPDATE REGISTER_USER SET PASSWORD = ?, IS_FIRST_LOGIN = ? WHERE USER_NAME = ?";
		boolean flag = false;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, password);
			preparedStatement.setBoolean(2, true);
			preparedStatement.setString(3, username);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			System.out.print("Oops! SQL Error: -> ");
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public boolean isEligible(String username, String password) {
		boolean flag = false;

		String sqlQuery = "SELECT * FROM REGISTER_USER WHERE USER_NAME = ? AND PASSWORD = ?";
		ResultSet resultSet = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString("USER_NAME").equals(username)
						&& resultSet.getString("PASSWORD").equals(password))
					flag = true;
				else
					flag = false;
				break;
			}
		} catch (SQLException e) {
			System.out.print("Oops! SQL Error: -> ");
			System.out.println(e.getMessage());
		}
		return flag;
	}

}
