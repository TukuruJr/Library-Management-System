package com.java.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	String  driver,username,password;
	  public java.sql.Connection connect;

	public Connection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		driver = "com.mysql.cj.jdbc.Driver";
		username = "root";
		password = "";
		
		Class.forName(driver);
		
		connect = DriverManager.getConnection("jdbc:mysql://localhost/library",username,password);
		
	}
}
