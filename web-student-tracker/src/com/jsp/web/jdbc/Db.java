package com.jsp.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class Db 
{
	public static Connection getCon() throws Exception {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		String url = "jdbc:mysql://localhost:3306/web_student_tracker?user=root&password=root"; 
		Connection connection = DriverManager.getConnection(url);
		return connection;
	}
}
