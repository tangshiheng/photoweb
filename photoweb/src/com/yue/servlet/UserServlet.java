package com.yue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yue.bean.User;
import com.yue.service.UserService;
import com.yue.service.impl.UserServiceImpl;
import com.yue.util.Utils;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	public UserServlet() {
		 userService = new UserServiceImpl();
	}
	//登陆
	@SuppressWarnings("unchecked")
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user = (User) Utils.copyParameter2Properties(request.getParameterMap(), user);
		//调用service的方法
		User user2 = userService.byUsernameAndPasswordToUser(user.getUsername(), user.getPassword());
		System.out.println("登陆的用户信息:"+user2);
		request.getSession().setAttribute("user", user2);
		//response.sendRedirect(request.getContextPath()+"/photoServlet?action=pagePhoto");
		request.getRequestDispatcher("photoServlet?action=pagePhoto").forward(request, response);
	}
	//注册
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user = (User) Utils.copyParameter2Properties(request.getParameterMap(), user);
		//调用service的方法
		User byUsername = userService.userByUsername(user.getUsername());	
		if(byUsername==null) {
			int regist = userService.regist(user);
			System.out.println("注册："+regist);
			request.getRequestDispatcher("user/regist.html").forward(request, response);
		}else {
			request.getRequestDispatcher("user/regist_error.html").forward(request, response);
		}
	}

}
