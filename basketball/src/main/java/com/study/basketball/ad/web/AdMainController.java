package com.study.basketball.ad.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @title	: [관리자] 메인 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.13
 */
@Controller
@RequestMapping("/ad/")
public class AdMainController {

	/**
	 * @title   : 관리자 메인 화면
	 * @author	: 김모세
	 * @create	: 2022.07.13
	 */
	@RequestMapping("main")
	public ModelAndView main(ModelAndView mav) {
		mav.setViewName("basketball/ad/VWAD0001");
		return mav;
	}
}
