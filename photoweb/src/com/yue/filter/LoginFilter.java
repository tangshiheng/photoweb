package com.yue.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yue.bean.User;

/**
 * 加载时看用户是否登录
 * @author yuexianchang
 *
 */

public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null) {
			chain.doFilter(request, response);
		}else {
			request.setAttribute("meg", "需要登录用户");
			request.getRequestDispatcher("/user/login.html").forward(request, response);
		}
	}

}
