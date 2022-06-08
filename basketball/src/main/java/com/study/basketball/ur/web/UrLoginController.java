package com.study.basketball.ur.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @title	: ȸ������ Controller Ŭ����	  
 * @author	: ���
 * @create	: 2022.06.04
 */
@Controller
@RequestMapping("/ur/")
public class UrLoginController {

	/**
	 * @title   : �α��� ȭ��
	 * @method  : login()
	 * @comment : �α��� ȭ������ �̵�
	 * @param   : N/A
	 */
	@RequestMapping("login")
	public ModelAndView login(ModelAndView mav) throws Exception {
		mav.setViewName("basketball/ur/VWUR0001");
		return mav;
	}
	
	/**
	 * @title   : ȸ������ ȭ��
	 * @method  : signUp()
	 * @comment : ȸ������ ȭ������ �̵�
	 * @param   : N/A
	 */
	@RequestMapping("signUp")
	public ModelAndView signUp(ModelAndView mav) throws Exception {
		mav.setViewName("basketball/ur/VWUR0002");
		return mav;
	}
}
