package com.study.basketball.cm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @title	: [공통] 메인 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.04
 */
@Controller
@RequestMapping("/")
public class CmMainController {

	@GetMapping("/")
	public String main(Model model) {
		return "redirect:/ur/login";
	}
	
	/**
	 * @title   : 메인 화면
	 * @method  : main()
	 * @comment : 메인 화면으로 이동
	 * @param   : N/A
	 */
	@RequestMapping("main")
	public ModelAndView main(ModelAndView mav) throws Exception {
		mav.setViewName("basketball/cm/VWCM0001");
		return mav;
	}	
}
