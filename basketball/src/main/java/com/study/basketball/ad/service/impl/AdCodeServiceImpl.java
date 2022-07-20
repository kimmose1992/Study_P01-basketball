package com.study.basketball.ad.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.study.basketball.ad.domain.dto.AdCodeMasterDTO;
import com.study.basketball.ad.service.AdCodeService;

/**
 * @title	: [관리자] 공통코드 Service 구현 클래스
 * @author	: 김모세
 * @create	: 2022.07.20
 */
@Service
public class AdCodeServiceImpl implements AdCodeService {

	private static final Logger logger = LoggerFactory.getLogger(AdCodeServiceImpl.class);
	
	/**
	 * @title   : 코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.07.20
	 */
	@Override
	public List<AdCodeMasterDTO> getCodeList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
