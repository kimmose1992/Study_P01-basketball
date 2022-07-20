package com.study.basketball.ad.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.basketball.ad.domain.dto.AdCodeMasterDTO;
import com.study.basketball.ad.service.AdCodeService;

/**
 * @title	: [관리자] 공통코드 관리 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.14
 */
@Controller
@RequestMapping("/ad/")
public class AdCodeController {

	@Autowired
	private AdCodeService adcodeService;
	
	/**
	 * @title   : 공통코드 목록 화면
	 * @author	: 김모세
	 * @create	: 2022.07.20
	 */
	@RequestMapping("codeList")
	public ModelAndView codeList(ModelAndView mav) throws Exception {
		
		List<AdCodeMasterDTO> codeMasterDTOList = adcodeService.getCodeList();
		
		mav.addObject("codeMasterDTOList", codeMasterDTOList);
		mav.setViewName("basketball/ad/VWAD3001");
		return mav;
	}
}
