package com.study.basketball.cm.security;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private CmSecurityUserDetailsService cmSecurityUserDetailsService;
	
	/**
	 * [AuthenticationProvider]
	 * 로그인 시, AuthenticationManager에서 해당 작업을 처리할 Provider에게 위임
	 * 
	 * [authentication] 
	 * 인증정보 객체 리턴 (= UsernameAuthenticationToken)
	 * - Principal		:: 식별된 사용자 정보 (= UserDetails의 인스턴스)
	 * - Credentials	:: 사용자에 대한 자격 증명
	 * - Authorities	:: 
	 * 
	 * [method]
	 * 아이디		:: authentication.getName(), authentication.getPrincipal()
	 * 비밀번호 	:: authentication.getCredentials()
	 * 상세정보 	:: authentication.getDetails()
	 * 권한목록 	:: Collection<? extends GrantedAuthority> getAuthorities()
	 * 인증여부	:: boolean isAuthenticated()
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		cmSecurityUserDetailsService.loadUserByUsername(username);
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
