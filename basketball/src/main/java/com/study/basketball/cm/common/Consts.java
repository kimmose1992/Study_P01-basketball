package com.study.basketball.cm.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title	: [공통] 상수 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.01
 */
public class Consts {

	// --------------------------------------------------------
	// ■ 사용자 권한
	// --------------------------------------------------------
	@Getter
	@AllArgsConstructor
	public enum UserRoles {
		USER_ROLE_A("ROLE_ADMIN")	// 관리자
	  , USER_ROLE_S("ROLE_STEP")	// 스탭
	  , USER_ROLE_N("ROLE_USER");	// 일반
		
		private String roleName;
	}
}
