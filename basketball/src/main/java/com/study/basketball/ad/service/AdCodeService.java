package com.study.basketball.ad.service;

import java.util.List;

import com.study.basketball.ad.domain.dto.AdCodeDetailDTO;
import com.study.basketball.ad.domain.dto.AdCodeMasterDTO;

/**
 * @title	: [관리자] 공통코드 관리 Service 인터페이스
 * @author	: 김모세
 * @create	: 2022.07.20
 */
public interface AdCodeService {

	/**
	 * @title   : 마스터 코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.07.20
	 */
	List<AdCodeMasterDTO> getCodeList() throws Exception;

	/**
	 * @title   : 디테일 코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.07.21
	 */
	List<AdCodeDetailDTO> getCodeDetailList(AdCodeDetailDTO adCodeDetailDTO) throws Exception;

}
