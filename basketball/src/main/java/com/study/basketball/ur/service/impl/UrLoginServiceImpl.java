package com.study.basketball.ur.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.basketball.ur.dao.UrLoginDAO;
import com.study.basketball.ur.service.UrLoginService;
import com.study.basketball.ur.vo.UrLoginVO;

/**
 * @title	: [사용자] 로그인 Service 구현 클래스
 * @author	: 김모세
 * @create	: 2022.06.08
 */
@Service
public class UrLoginServiceImpl implements UrLoginService {

	private static final Logger logger = LoggerFactory.getLogger(UrLoginServiceImpl.class);
	
	@Autowired
	private UrLoginDAO urLoginDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * @title   : 회원가입 정보 저장
	 * @author	: 김모세
	 * @create	: 2022.06.16
	 */
	@Override
	public int signUpSave(UrLoginVO urLoginVO) throws Exception {
		try {
			// 비밀번호 암호화
			urLoginVO.setUserPw(passwordEncoder.encode(urLoginVO.getUserPw()));
			
			// 회원가입 정보 저장
			int resultCnt = urLoginDAO.signUpSave(urLoginVO);
			
			if (resultCnt <= 0) {
				urLoginVO.builder().isError(true);
				throw new Exception("회원가입 저장 ERROR");
			}
		} catch (Exception e) {
			logger.debug("#############################");
			logger.debug("## " + e.getMessage());
			logger.debug("#############################");
		}
		
		urLoginVO.builder().build();
		
		return resultCnt;
	}

}
