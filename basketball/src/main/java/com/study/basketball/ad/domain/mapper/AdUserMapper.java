package com.study.basketball.ad.domain.mapper;

import com.study.basketball.ad.domain.dto.AdUserDTO;
import com.study.basketball.ad.domain.entity.AdUserEntity;

/**
 * @title	: [관리자] 사용자 도메인 매퍼 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.18
 */
public class AdUserMapper {

	public AdUserDTO toDto(AdUserEntity adUserEntity) {
		AdUserDTO adUserDTO = new AdUserDTO();
		adUserDTO.setUserSeq(adUserEntity.getUserSeq());
		adUserDTO.setUserDivCd(adUserEntity.getUserDivCd());
		adUserDTO.setUserId(adUserEntity.getUserId());
		adUserDTO.setUserName(adUserEntity.getUserName());
		adUserDTO.setUserLevelCd(adUserEntity.getUserLevelCd());
		adUserDTO.setUserBirth(adUserEntity.getUserBirth());
		adUserDTO.setUserGenderCd(adUserEntity.getUserGenderCd());
		adUserDTO.setUserNickname(adUserEntity.getUserNickname());
		adUserDTO.setUseYn(adUserEntity.getUseYn());		
		adUserDTO.setUserJoinDt(adUserEntity.getUserJoinDt());		
		
		return adUserDTO;
	}
	
	public AdUserEntity toEntity(AdUserDTO adUserDTO) {
		return AdUserEntity.builder().adUserDTO(adUserDTO).build();
	}
}
