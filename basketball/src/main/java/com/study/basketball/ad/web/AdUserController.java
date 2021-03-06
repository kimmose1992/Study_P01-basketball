package com.study.basketball.ad.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.basketball.ad.domain.dto.AdUserDTO;
import com.study.basketball.ad.service.AdUserService;

/**
 * @title	: [관리자] 사용자 관리 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.14
 */
@RestController
@RequestMapping("/ad/")
public class AdUserController {

	@Autowired
	private AdUserService adUserService;
	
	/**
	 * @title   : 사용자 목록 화면
	 * @author	: 김모세
	 * @create	: 2022.07.14
	 */
	@RequestMapping("userList")
	public ModelAndView userList(ModelAndView mav) throws Exception {
		
		List<AdUserDTO> userDTOList = adUserService.getUserList();
		
		mav.addObject("userDTOList", userDTOList);
		mav.setViewName("basketball/ad/VWAD2001");
		return mav;
	}
}
