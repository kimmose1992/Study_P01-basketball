package com.study.basketball.ad.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.basketball.ad.domain.dto.AdCodeDetailDTO;
import com.study.basketball.ad.domain.dto.AdCodeMasterDTO;
import com.study.basketball.ad.service.AdCodeService;

/**
 * @title	: [관리자] 공통코드 관리 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.14
 */
@RestController
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
	public ModelAndView codeList(AdCodeDetailDTO adCodeDetailDTO, ModelAndView mav) throws Exception {
		
		// 마스터 코드 조회
		List<AdCodeMasterDTO> codeMasterDTOList = adcodeService.getCodeList();
		
		// 디테일 코드 조회
		List<AdCodeDetailDTO> codeDetailDTOList = adcodeService.getCodeDetailList(adCodeDetailDTO);
		
		mav.addObject("codeMasterDTOList", codeMasterDTOList);
		mav.addObject("codeDetailDTOList", codeDetailDTOList);
		mav.setViewName("basketball/ad/VWAD3001");
		return mav;
	}
}
