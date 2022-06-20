package com.study.basketball.cm.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @title	: [공통] HandlerInterceptor 구현 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.20
 */
public class CmGlobalHandler implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(CmGlobalHandler.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("[Start Request URI] :: " + request.getRequestURI());
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}
}
