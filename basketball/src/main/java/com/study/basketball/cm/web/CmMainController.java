package com.study.basketball.cm.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.basketball.cm.security.CmSecurityHelper;

/**
 * @title 	: [공통] 메인 Controller 클래스
 * @author	: 김모세
 * @create 	: 2022.06.04
 */
@Controller
@RequestMapping("/")
public class CmMainController {

	@RequestMapping("/")
	public String index(HttpServletRequest request, RedirectAttributes redirect) throws Exception {

		String redirectUrl = "";

		if (CmSecurityHelper.isAuthenticated()) {
			redirectUrl = "/main";
		} else {
			redirectUrl = "/ur/login";
		}

		String userId = (String) request.getAttribute("userId");
		String loginFailMsg = (String) request.getAttribute("loginFailMsg");

		redirect.addFlashAttribute("userId", userId);
		redirect.addFlashAttribute("loginFailMsg", loginFailMsg);
		return "redirect:" + redirectUrl;
	}

	/**
	 * @title 	: 메인 화면
	 * @method 	: main()
	 * @comment	: 메인 화면으로 이동
	 * @param 	: N/A
	 */
	@RequestMapping("main")
	public ModelAndView main(ModelAndView mav) throws Exception {
		mav.setViewName("basketball/cm/VWCM1001");
		return mav;
	}
}
