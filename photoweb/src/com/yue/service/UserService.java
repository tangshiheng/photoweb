package com.yue.service;

import com.yue.bean.User;

public interface UserService {
		//注册用户（添加）
		public int regist(User user);
		//根据姓名查找用户
		public User userByUsername(String username);
		//验证用户
		public User byUsernameAndPasswordToUser(String username,String password);
		
}
