package com.study.basketball.cm.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.study.basketball.cm.common.Consts;

@Component
public class CmLoginFailureHandler implements AuthenticationFailureHandler {

	private static final Logger logger = LoggerFactory.getLogger(CmLoginFailureHandler.class);
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		
		String loginFaliMsg = "";
		String exceptionName = exception.getClass().getSimpleName();
		
		try {
			loginFaliMsg = Consts.UserAuthExMsg.valueOf(exceptionName).getValue();
		} catch (IllegalArgumentException e) {
			loginFaliMsg = Consts.UserAuthExMsg.NoneException.getValue();
		}
		
		logger.info("=========================================================");
		logger.info("## Login Failure");
		logger.info("## loginFailMsg :: " + loginFaliMsg);
		logger.info("=========================================================");
		
		request.setAttribute("userId", request.getParameter("userId"));
		request.setAttribute("loginFailMsg", loginFaliMsg);
		
		// 로그인 페이지로 다시 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ur/login");
		dispatcher.forward(request, response);
	}

}
