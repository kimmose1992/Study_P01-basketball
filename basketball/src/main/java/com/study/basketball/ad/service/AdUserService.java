package com.study.basketball.ad.service;

import java.util.List;

import com.study.basketball.ad.domain.dto.AdUserDTO;

/**
 * @title	: [관리자] 사용자 관리 Service 인터페이스
 * @author	: 김모세
 * @create	: 2022.07.14
 */
public interface AdUserService {

	/**
	 * @title   : 사용자 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.07.14
	 */
	List<AdUserDTO> getUserList() throws Exception;

}
