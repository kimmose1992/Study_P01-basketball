package com.study.basketball.ur.domain.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.study.basketball.cm.domain.dto.CmBaseDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @title	: [사용자] 로그인 DTO 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.08
 */
@Getter
@Setter
public class UrLoginDTO extends CmBaseDTO {
	
	/** 사용자 테이블 */
	private int userSeq;								// SEQ
	private String userDivCd;							// 구분코드
	private String userRole;							// 권한
	private String userId;								// 아이디
	private String userPw;								// 비밀번호
	private String userName;							// 이름
	private String userLevelCd;							// 레벨코드
	private String userBirth;							// 생년월일
	private String userGenderCd;						// 성별코드
	private String userNickname;						// 닉네일
	private String userStatCd;							// 상태코드

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime userJoinDt;					// 가입일시

}