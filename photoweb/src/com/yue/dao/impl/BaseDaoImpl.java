package com.yue.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import com.yue.util.JDBCUtils;

public abstract class BaseDaoImpl<T> {
	QueryRunner queryRunner;
	Class<T> type;//获取泛型
	
	public BaseDaoImpl(){
		queryRunner  = new QueryRunner();
		ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
		type = (Class<T>) superclass.getActualTypeArguments()[0];
	}
	
	//获取对象集合
	public List<T> getList(String sql,Object...objects){
		Connection connection;
		try {
			connection= JDBCUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<T>(type), objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//获取单个对象
	public T getOne(String sql,Object...objects) {
		Connection connection;
		try {
			connection= JDBCUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<T>(type), objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//获取单个对象的单个值
	public Object getObject(String sql,Object...objects) {
		Connection connection;
		try {
			connection= JDBCUtils.getConnection();
			return queryRunner.query(connection, sql, new ScalarHandler(), objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//获取更新影响的行数
	public int getUpdate(String sql,Object...objects) {
		Connection connection;
		try {
			connection= JDBCUtils.getConnection();
			return queryRunner.update(connection, sql, objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
