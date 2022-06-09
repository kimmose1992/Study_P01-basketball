package com.gdgs.slyouth.nt.vo;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.cm.vo.CmVideoSVO;

/**
 * @title  : [커뮤니티] 영상 SVO 클래스
 * @author : 김모세
 * @create : 2021.08.01
 */
public class NtVideoSVO {

	// 영상 SVO 
	private CmVideoSVO cmVideoSVO;
	
	// 페이징 DVO
	private CmPagingOutDVO cmPagingDVO;

	public CmVideoSVO getCmVideoSVO() {
		return cmVideoSVO;
	}

	public void setCmVideoSVO(CmVideoSVO cmVideoSVO) {
		this.cmVideoSVO = cmVideoSVO;
	}

	public CmPagingOutDVO getCmPagingDVO() {
		return cmPagingDVO;
	}

	public void setCmPagingDVO(CmPagingOutDVO cmPagingDVO) {
		this.cmPagingDVO = cmPagingDVO;
	}

	@Override
	public String toString() {
		return "WsWorshipSVO [cmVideoSVO=" + cmVideoSVO + ", cmPagingDVO=" + cmPagingDVO + "]";
	}
}
