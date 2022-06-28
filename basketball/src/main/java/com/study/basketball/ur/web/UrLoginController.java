package com.study.basketball.ur.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.basketball.ur.dto.UrLoginDTO;
import com.study.basketball.ur.service.UrLoginService;

/**
 * @title	: [사용자] 로그인 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.04
 */
@RestController
@RequestMapping("/ur/")
public class UrLoginController {

	@Autowired
	private UrLoginService urLoginService;
	
	/**
	 * @title   : 로그인 화면
	 * @author	: 김모세
	 * @create	: 2022.06.14
	 */
	@RequestMapping("login")
	public ModelAndView login(ModelAndView mav) throws Exception {
		mav.setViewName("basketball/ur/VWUR0001");
		return mav;
	}
	
	/**
	 * @title   : 회원가입 화면
	 * @author	: 김모세
	 * @create	: 2022.06.14
	 */
	@RequestMapping("signUp")
	public ModelAndView signUp(ModelAndView mav) throws Exception {
		mav.setViewName("basketball/ur/VWUR0002");
		return mav;
	}
	
	/**
	 * @title   : 회원가입 정보 저장
	 * @author	: 김모세
	 * @create	: 2022.06.16
	 */
	@PostMapping("signUpSave")
	public UrLoginDTO signUpSave(UrLoginDTO urLoginDto) throws Exception {
		return urLoginService.signUpSave(urLoginDto);
	}	
}
