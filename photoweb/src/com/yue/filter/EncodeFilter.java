package com.yue.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncodeFilter
 */
public class EncodeFilter extends HttpFilter{
	
	/**
	 * 设置字符集的过滤器
	 * 分析:
	 * 1.首先获取filterconfig的对象，
	 * 2.获取上下文对象
	 * 3.通过上下文对象来获取参数
	 * 4.通过request的来设置编码类型
	 * 5.最后放行
	 */
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//获取web.xml中设置的字符集
		
		//获取FilterConfig对象
		FilterConfig filterConfig = getFilterConfig();
		//获取Servlet的上下文对象
		ServletContext servletContext = filterConfig.getServletContext();
		//获取初始的参数
		String encode = servletContext.getInitParameter("encode");
		
		request.setCharacterEncoding(encode);
		
		//最后放行请求
		chain.doFilter(request, response);
	}

}
