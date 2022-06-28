package com.study.basketball.ur.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.basketball.ur.dao.UrLoginDAO;
import com.study.basketball.ur.dto.UrLoginDTO;
import com.study.basketball.ur.service.UrLoginService;

/**
 * @title	: [사용자] 로그인 Service 구현 클래스
 * @author	: 김모세
 * @create	: 2022.06.08
 */
@Service
public class UrLoginServiceImpl implements UrLoginService {

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
	public UrLoginDTO signUpSave(UrLoginDTO urLoginDto) throws Exception {
		// 비밀번호 암호화
		urLoginDto.setUserPw(passwordEncoder.encode(urLoginDto.getUserPw()));
		
		// 회원가입 정보 저장
		int resultCnt = urLoginDAO.signUpSave(urLoginDto);
		
		if (resultCnt <= 0) {
			throw new Exception("회원가입 정보 저장 실패");
		}
		
		UrLoginDTO responseDto = new UrLoginDTO(); 
		responseDto.setResultCnt(resultCnt);
		return responseDto;
	}

}
