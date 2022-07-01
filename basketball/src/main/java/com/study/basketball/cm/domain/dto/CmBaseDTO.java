package com.study.basketball.cm.domain.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * @title	: [공통] 공통 DTO 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.13
 */
@Getter
@Setter
public class CmBaseDTO {

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime regDt;						// 등록일시
	private Long regUser;								// 등록자
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime mdfDt;						// 수정일시
	private Long mdfUser;								// 수정자
	
	private boolean isError = false;					// 에러여부
	private int resultCnt;								// 결과건수
}
