package com.study.basketball.cm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @title	: [����] ���� Controller Ŭ����	  
 * @author	: ���
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
	 * @title   : ���� ȭ��
	 * @method  : main()
	 * @comment : ���� ȭ������ �̵�
	 * @param   : N/A
	 */
	@RequestMapping("main")
	public ModelAndView main(ModelAndView mav) throws Exception {
		mav.setViewName("basketball/cm/VWCM0001");
		return mav;
	}	
}
