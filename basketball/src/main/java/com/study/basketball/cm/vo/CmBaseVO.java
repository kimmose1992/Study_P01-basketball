package com.study.basketball.cm.vo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @title	: [공통] 공통 VO 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.13
 */
@Getter
@SuperBuilder
@AllArgsConstructor
public class CmBaseVO {

	private int userSeq;								// 사용자 SEQ
	private String userId;								// 사용자 아이디
	private String userName;							// 사용자 이름
	private String userNickname;						// 사용자 닉네임
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime regDt;						// 등록일시
	private int regUser;								// 등록자
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime mdfDt;						// 수정일시
	private int mdfUser;								// 수정자
	
	@Builder.Default
	private boolean isError = false;					// 에러여부
}
