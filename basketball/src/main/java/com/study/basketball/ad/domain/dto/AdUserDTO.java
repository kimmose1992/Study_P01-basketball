package com.study.basketball.ad.domain.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.study.basketball.ad.domain.entity.AdUserEntity;
import com.study.basketball.cm.domain.dto.CmBaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @title	: [관리자] 사용자 DTO 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.14
 */
@Getter
@Setter
@NoArgsConstructor
public class AdUserDTO extends CmBaseDTO {

	/** 사용자 테이블 */
	private Long userSeq;								// SEQ
	private String userDivCd;							// 구분코드
	private String userRole;							// 권한
	private String userId;								// 아이디
	private String userPw;								// 비밀번호
	private String userName;							// 이름
	private String userLevelCd;							// 레벨코드
	private String userBirth;							// 생년월일
	private String userGenderCd;						// 성별코드
	private String userNickname;						// 닉네임
	private String useYn;								// 상태코드

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime userJoinDt;					// 가입일시
	
	public AdUserDTO(AdUserEntity adUserEntity) {
		this.userSeq 		= adUserEntity.getUserSeq();
		this.userDivCd 		= adUserEntity.getUserDivCd();
		this.userId 		= adUserEntity.getUserId();
		this.userName 		= adUserEntity.getUserName();
		this.userLevelCd 	= adUserEntity.getUserLevelCd();
		this.userBirth 		= adUserEntity.getUserBirth();
		this.userGenderCd	= adUserEntity.getUserGenderCd();
		this.userNickname 	= adUserEntity.getUserNickname();
		this.useYn 			= adUserEntity.getUseYn();
		this.userJoinDt 	= adUserEntity.getUserJoinDt();
	}
	
	public AdUserEntity toEntity() {
		AdUserDTO adUserDTO = new AdUserDTO();
		adUserDTO.setUserSeq(userSeq);
		adUserDTO.setUserDivCd(userDivCd);
		adUserDTO.setUserId(userId);
		adUserDTO.setUserName(userName);
		adUserDTO.setUserLevelCd(userLevelCd);
		adUserDTO.setUserBirth(userBirth);
		adUserDTO.setUserGenderCd(userGenderCd);
		adUserDTO.setUserNickname(userNickname);
		adUserDTO.setUseYn(useYn);
		
		return AdUserEntity.builder().adUserDTO(adUserDTO).build();
	}
	
	/**
	 * Entity에 @Setter가 있는 경우
	 */
	/*
	 * public AdUserEntity toEntity() {
	 *     AdUserEntity adUserEntity = new AdUserEntity();
	 *     
	 *     adUserEntity.setUserSeq(this.userSeq);
	 *     adUserEntity.setUserDivCd(this.userDivCd);
	 *     adUserEntity.setUserId(this.userId);
	 *     return adUserEntity;
	 * }
	 */
}
