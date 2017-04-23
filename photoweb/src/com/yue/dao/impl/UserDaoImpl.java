package com.yue.dao.impl;

import com.yue.bean.User;
import com.yue.dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public int regist(User user) {
		String sql = "insert into user values(null,?,?,?,?)";
		return getUpdate(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone());
	}

	@Override
	public User userByUsername(String username) {
		String sql = "select * from user where username = ?";
		return getOne(sql, username);
	}

	@Override
	public User byUsernameAndPasswordToUser(String username, String password) {
		String sql = "select * from user where username = ? and password = ?";
		return getOne(sql, username,password);
	}
	
}
