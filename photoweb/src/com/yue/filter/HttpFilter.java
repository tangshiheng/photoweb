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


/*
 *专门继承的类
 */
public abstract class HttpFilter implements Filter {
	
	private FilterConfig config;
	
	public FilterConfig getFilterConfig() {
		return config;	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
		this.init();
	}
	//专门用来被重新方法
	public void init() {
		
	}
	
    public HttpFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		doFilter(req, res,chain);
	}

	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws IOException, ServletException;
	

}
