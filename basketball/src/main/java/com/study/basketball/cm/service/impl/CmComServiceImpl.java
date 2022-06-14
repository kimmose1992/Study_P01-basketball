package com.study.basketball.cm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.basketball.cm.dao.CmComDAO;
import com.study.basketball.cm.service.CmComService;
import com.study.basketball.cm.vo.CmCodeVO;

/**
 * @title	: [공통] 기능관리 Service 구현 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.14
 */
@Service
public class CmComServiceImpl implements CmComService {

	@Autowired
	private CmComDAO cmComDAO;
	
	/**
	 * @title   : 공통코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.06.14
	 */
	@Override
	public CmCodeVO comCodeList(CmCodeVO cmCodeVO) throws Exception {
		cmCodeVO.setCmCodeVOList(cmComDAO.comCodeList(cmCodeVO));
		return cmCodeVO;
	}

}
