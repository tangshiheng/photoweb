package com.yue.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("c3p0");
	//获取连接
	public static Connection getConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		return connection;
	}
	//关闭连接
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
