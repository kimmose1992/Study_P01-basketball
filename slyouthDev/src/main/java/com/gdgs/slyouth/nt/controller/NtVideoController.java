package com.gdgs.slyouth.nt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.cm.vo.CmVideoDVO;
import com.gdgs.slyouth.nt.service.NtVideoService;
import com.gdgs.slyouth.nt.vo.NtVideoSVO;

/**
 * @title  : [커뮤니티] 영상 Controller 클래스
 * @author : 김모세
 * @create : 2021.08.01
 */
@RestController
@RequestMapping("/nt/")
public class NtVideoController {
	
	@Autowired
	private NtVideoService ntVideoService;
	
	/**
	 * @title 	: 영상 정보 조회 페이지
	 * @method 	: videoList()
	 * @comment : 영상 정보 조회 화면으로 이동한다. (승리청년채널)
	 * @param 	: CmVideoDVO
	 */
	@RequestMapping("video")
	public ModelAndView videoList(CmVideoDVO cmVideoDVO, ModelAndView mav) throws Exception {
		
	    NtVideoSVO returnSVO = ntVideoService.selectVideoList(cmVideoDVO);

	    mav.addObject("videoDivCd", cmVideoDVO.getVideoDivCd());
	    mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0013");
		return mav;
	}

	/**
	 * @title   : 영상 정보 등록/수정 페이지
	 * @method  : videoEdit()
	 * @comment : 영상 정보 등록/수정 페이지로 이동한다.
	 * @param   : CmVideoDVO
	 */
	@PostMapping("videoEdit")
	public ModelAndView videoEdit(CmVideoDVO cmVideoDVO, ModelAndView mav, HttpServletRequest request) throws Exception {

		cmVideoDVO.setVideoTypeCd(new CmConvKeyUtils().getVdTypeKey(request.getRequestURI(), cmVideoDVO.getVideoDivCd()));
		NtVideoSVO returnSVO = ntVideoService.selectVideo(cmVideoDVO);

		mav.addObject("videoDivCd", cmVideoDVO.getVideoDivCd());
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0014");
		return mav;
	}

	/**
	 * @title	: 영상 정보 저장   
	 * @method	: videoSave()	 
	 * @comment	: 영상 정보를 등록 및 수정한다.
	 * @param	: CmVideoDVO
	 */
	@PostMapping("videoSave")
	public int videoSave(CmVideoDVO cmVideoDVO) throws Exception {
		return ntVideoService.videoSave(cmVideoDVO);
	}

	/**
	 * @title 	: 영상 정보 삭제
	 * @method 	: videoDel()
	 * @comment	: 영상 정보를 삭제한다.
	 * @param 	: CmVideoDVO
	 */
	@PostMapping("videoDel")
	public int videoDel(CmVideoDVO cmVideoDVO) throws Exception {
		return ntVideoService.videoDel(cmVideoDVO);
	}
}
