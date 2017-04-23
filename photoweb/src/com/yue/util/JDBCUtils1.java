package com.yue.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JDBCUtils1 {
	static String url;
	static String username;
	static String password;
	static String className;
	static {
		Properties pro = new Properties();
		
		try {
			InputStream is = JDBCUtils1.class.getClassLoader().getResourceAsStream("dbcp.properties");
			pro.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		url = pro.getProperty("url");
		username = pro.getProperty("username");
		password = pro.getProperty("password");
		className = pro.getProperty("driverClassName");
		
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(className);
		return DriverManager.getConnection(url, username, password);
	}
	public static void closeConnection(ResultSet set,Statement statement,Connection connection) throws SQLException {
		if(set!=null) {
			set.close();
		}
		if(statement!=null) {
			statement.close();
		}
		if(connection!=null) {
			connection.close();
		}
	}
}
