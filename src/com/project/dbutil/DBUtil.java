package com.project.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	// =======================================================
	// -----------Connection Properties for H2 DB-------------
	// =======================================================
	private static final String DRIVER = "org.h2.Driver";
	private static final String DBURL = "jdbc:h2:tcp://localhost/~/testing";
	private static final String DBUSER = "sa";
	private static final String DBPASSWORD = "sa";
	// ========================================================

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			if (connection != null)
				System.out.println("Woohoo! Connection Established Successfully!");
		} catch (ClassNotFoundException e) {
			System.out.print("Oops! Error while establishing connection -> ");
			System.out.println("Driver Class Not Found: " + e.getMessage());
		} catch (SQLException e) {
			System.out.print("Oops! Error while establishing connection -> ");
			System.out.println("SQL Exception: " + e.getMessage());
		}
		return connection;
	}

	public static void main(String[] args) {
		getConnection();
	}

}
