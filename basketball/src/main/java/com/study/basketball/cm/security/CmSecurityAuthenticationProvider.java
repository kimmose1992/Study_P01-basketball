package com.study.basketball.cm.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @title	: Spring Security AuthenticationProvider 구현 클래스
 * @author	: 김모세
 * @create	: 2022.06.30
 */
public class CmSecurityAuthenticationProvider implements AuthenticationProvider {

	/**
	 * 로그인 시, AuthenticationManager에서 해당 작업을 처리할 Provider에게 위임
	 * authentication 인증정보 객체 리턴 (= UsernameAuthenticationToken)
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
