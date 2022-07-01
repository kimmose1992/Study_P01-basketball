package com.study.basketball.cm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.basketball.ur.dao.UrLoginDAO;
import com.study.basketball.ur.domain.dto.UrLoginDTO;

/**
 * @title	: Spring Security UserDetailsService 구현 클래스
 * @author	: 김모세
 * @create	: 2022.07.01
 */
@Service
public class CmSecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private UrLoginDAO urLoginDAO;
	
	/**
	 * [UserDetailsService] 
	 * 사용자 정보를 가져오는 인터페이스
	 * 
	 * [loadUserByUsername]
	 * 사용자 정보를 가져와서 UserDetails 리턴
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UrLoginDTO userInfo = urLoginDAO.loadUserByUsername(username);
				
		return null;
	}

}
