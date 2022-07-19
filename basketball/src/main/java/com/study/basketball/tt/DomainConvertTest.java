package com.study.basketball.tt;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.study.basketball.ad.domain.dto.AdUserDTO;
import com.study.basketball.ad.domain.entity.AdUserEntity;
import com.study.basketball.ad.domain.mapper.AdUserMapper;

class DomainConvertTest {

	@Test
	void test() {
		
		ModelMapper modelMapper = new ModelMapper();
		AdUserMapper adUserMapper = new AdUserMapper();
		
		/**
		 * DTO To Entity
		 */
		AdUserDTO sourceDto = new AdUserDTO();
		//sourceDto.setUserSeq(0L);
		sourceDto.setUserId("admin");
		sourceDto.setUserName(null);
		
		AdUserEntity toEntity01 = sourceDto.toEntity();
//		System.out.println("toEntity01 :: " + toEntity01.toString());
		
		AdUserEntity toEntity02 = modelMapper.map(sourceDto, AdUserEntity.class);
//		System.out.println("toEntity02 :: " + toEntity02.toString());
		
		AdUserEntity toEntity03 = adUserMapper.toEntity(sourceDto);
//		System.out.println("toEntity03 :: " + toEntity03.toString());
		
		/**
		 * Entity To DTO
		 */
		AdUserEntity sourceEntity = sourceDto.toEntity();
		
		AdUserDTO toDto01 = new AdUserDTO(sourceEntity);
//		System.out.println("toDto01 :: " + toDto01.toString());
		
		AdUserDTO toDto02 = modelMapper.map(sourceEntity, AdUserDTO.class);
//		System.out.println("toDto02 :: " + toDto02.toString());
		
		AdUserDTO toDto03 = adUserMapper.toDto(sourceEntity);
//		System.out.println("toDto03 :: " + toDto03.toString());
	}

}
