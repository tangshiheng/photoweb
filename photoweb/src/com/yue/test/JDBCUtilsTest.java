package com.yue.test;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

import com.yue.util.JDBCUtils1;
import com.yue.util.JDBCUtils;

public class JDBCUtilsTest {

	@Test
	public void testGetConnection() throws SQLException, ClassNotFoundException {
		Connection connection = JDBCUtils1.getConnection();
		System.out.println(connection);
	}
	@Test
	 public void testConnect2() throws SQLException {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
	}

}
