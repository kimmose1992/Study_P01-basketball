package com.study.basketball.cm.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.study.basketball.cm.utils.ObjectUtils;

/**
 * @title	: Spring Security Helper 클래스
 * @author	: 김모세
 * @create	: 2022.07.12
 */
public class CmSecurityHelper {

	private static final Logger logger = LoggerFactory.getLogger(CmSecurityHelper.class);
	
	/**
	 * @title	: 사용자 인증 여부	  
	 * @method	: isAuthenticated	 
	 * @comment	: 사용자 인증 여부를 체크하여 결과를 리턴한다.	 
	 * @param	: N/A
	 */
	public static boolean isAuthenticated() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		
		if (ObjectUtils.isNull(authentication)) {
			return false;
		}
		
		String userId = authentication.getPrincipal().toString();
		
		logger.info("--------------------------------------------------------");
		logger.info("[isAuthenticated] :: " + userId);
		logger.info("--------------------------------------------------------");
		
		if ("anonymousUser".equals(userId)) { 
			return false;
		}
		
		return true;
	}
}
