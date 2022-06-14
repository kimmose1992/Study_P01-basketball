package com.study.basketball.cm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.basketball.cm.service.CmComService;
import com.study.basketball.cm.vo.CmCodeVO;

/**
 * @title	: [공통] 기능관리 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.14
 */
@RestController
@RequestMapping("/cm/")
public class CmComController {

	@Autowired
	private CmComService cmComService;
	
	/**
	 * @title   : 공통코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.06.14
	 */
	@PostMapping("comCodeList")
	public CmCodeVO comCodeList(CmCodeVO cmCodeVO) throws Exception {
		return cmComService.comCodeList(cmCodeVO);
	}
}
