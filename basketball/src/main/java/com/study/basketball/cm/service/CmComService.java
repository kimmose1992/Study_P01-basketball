package com.study.basketball.cm.service;

import com.study.basketball.cm.dto.CmCodeDTO;

/**
 * @title	: [공통] 기능관리 Service 인터페이스	  
 * @author	: 김모세
 * @create	: 2022.06.14
 */
public interface CmComService {

	/**
	 * @title   : 공통코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.06.14
	 */
	CmCodeDTO comCodeList(CmCodeDTO cmCodeDTO) throws Exception;

}
