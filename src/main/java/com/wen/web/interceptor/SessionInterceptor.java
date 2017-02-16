package com.wen.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @author Wen
 * @CreatDate: 2016年6月12日
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		String s = WebUtils.readLoginToken(request);
		logger.info(handler.toString());
		return super.preHandle(request, response, handler);
	}
}
