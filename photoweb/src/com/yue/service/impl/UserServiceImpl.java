package com.yue.service.impl;

import com.yue.bean.User;
import com.yue.dao.UserDao;
import com.yue.dao.impl.UserDaoImpl;
import com.yue.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public int regist(User user) {
		return userDao.regist(user);
	}

	@Override
	public User userByUsername(String username) {
		return userDao.userByUsername(username);
	}

	@Override
	public User byUsernameAndPasswordToUser(String username, String password) {
		return userDao.byUsernameAndPasswordToUser(username, password);
	}
}
