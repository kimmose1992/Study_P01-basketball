package com.study.basketball.cm.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title	: [공통] 상수 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.01
 */
public class Consts {

	/**
	 * [상수] 	:: private final int USER_ROLE_A = "ROLE_ADMIN"
	 * - 가독성이 떨어짐
	 * - 타입 비교 안됨
	 * - 정수 상수 문자열 출력 어려움 > 별도 메소드 생성 필요
	 * 
	 * [ENUM]	:: eNum	: USER_ROLE_A("ROLE_ADMIN")
	 * jdk1.5 부터 추가, 서로 관련된 상수를 편리하게 선언 및 관리 용도
	 * - 타입 비교 가능
	 * - 코드가 간결해지고, 가독성이 좋음
	 * - 인스턴스 생성 및 상속 방지 :: 타입 안정성 보장 (ENUM 선언 외 값 할당 시 컴파일 에러 발생)
	 * - ENUM 이라는 것으로 구현 의도 명확히 파악 가능
	 * 
	 * 상수 	: private final int USER_ROLE_A = "ROLE_ADMIN"
	 * eNum	: USER_ROLE_A("ROLE_ADMIN")
	 */
	// --------------------------------------------------------
	// ■ 사용자 권한
	// --------------------------------------------------------
	@Getter
	@AllArgsConstructor
	public enum UserRoles {
		ROLE_A("ROLE_ADMIN")	// 관리자
	  , ROLE_S("ROLE_STEP")		// 스탭
	  , ROLE_N("ROLE_USER");	// 일반
		
		private String value;
	}
	
	// --------------------------------------------------------
	// ■ 사용자 인증 메세지
	// --------------------------------------------------------
	@Getter
	@AllArgsConstructor
	public enum UserAuthMsg {
		USERNAME_NOT_FOUND("계정을 찾을 수 없습니다.")
	  , BAD_CREDENTIALSE("잘못된 비밀번호입니다. 다시 시도하거나 비밀번호 찾기를 클릭하여 재설정하세요.");
		
		private String value;
	}	
}
