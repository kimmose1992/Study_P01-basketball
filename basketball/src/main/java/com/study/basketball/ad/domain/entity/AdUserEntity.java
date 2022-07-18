package com.study.basketball.ad.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.study.basketball.ad.domain.dto.AdUserDTO;
import com.study.basketball.cm.domain.entity.CmBaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @title	: [관리자] 사용자 Entity 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.14
 */
@Entity
@Table(name="P01_USER_M")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AdUserEntity extends CmBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long userSeq;				// SEQ
	
	@Column
	private String userDivCd;			// 구분코드
	
	@Column
	private String userRole;			// 권한
	
	@Column
	private String userId;				// 아이디
	
	@Column
	private String userPw;				// 비밀번호
	
	@Column
	private String userName;			// 이름
	
	@Column
	private String userLevelCd;			// 레벨코드
	
	@Column
	private String userBirth;			// 생년월일
	
	@Column
	private String userGenderCd;		// 성별코드
	
	@Column
	private String userNickname;		// 닉네임
	
	@Column
	private String useYn;				// 사용여부

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column
	private LocalDateTime userJoinDt;	// 가입일시	
	
	@Builder
	public AdUserEntity(AdUserDTO adUserDTO) {
		this.userSeq 		= adUserDTO.getUserSeq();
		this.userDivCd		= adUserDTO.getUserDivCd();
		this.userId 		= adUserDTO.getUserId();
		this.userName 		= adUserDTO.getUserName();
		this.userLevelCd	= adUserDTO.getUserLevelCd();
		this.userBirth 		= adUserDTO.getUserBirth();
		this.userGenderCd 	= adUserDTO.getUserGenderCd();
		this.userNickname 	= adUserDTO.getUserNickname();
		this.useYn 			= adUserDTO.getUseYn();
	}
}
