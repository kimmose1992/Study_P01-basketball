package com.study.basketball.ur.service;

import com.study.basketball.ur.domain.dto.UrLoginDTO;

/**
 * @title	: [사용자] 로그인 Service 인터페이스
 * @author	: 김모세
 * @create	: 2022.06.08
 */
public interface UrLoginService {

	/**
	 * @title   : 회원가입 정보 저장
	 * @author	: 김모세
	 * @create	: 2022.06.16
	 */
	UrLoginDTO signUpSave(UrLoginDTO urLoginDto) throws Exception;

}
