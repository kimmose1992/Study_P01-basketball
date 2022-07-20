package com.study.basketball.ad.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.basketball.ad.domain.dto.AdUserDTO;
import com.study.basketball.ad.domain.entity.AdUserEntity;
import com.study.basketball.ad.repository.AdUserRepository;
import com.study.basketball.ad.service.AdUserService;

/**
 * @title	: [관리자] 사용자 관리 Service 구현 클래스
 * @author	: 김모세
 * @create	: 2022.07.14
 */
@Service
public class AdUserServiceImpl implements AdUserService {

	private static final Logger logger = LoggerFactory.getLogger(AdUserServiceImpl.class);
	
	@Autowired
	private AdUserRepository adUserRepository;
	
	/**
	 * @title   : 사용자 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.07.14
	 */
	@Override
	public List<AdUserDTO> getUserList() throws Exception {
		List<AdUserEntity> userEntityList = adUserRepository.findAll();
		
		List<AdUserDTO> userDTOList = new ArrayList<AdUserDTO>();
		
		for(AdUserEntity adUserEntity : userEntityList) {
			AdUserDTO adUserDTO = new AdUserDTO(adUserEntity);
			userDTOList.add(adUserDTO);
		}

		return userDTOList;
	}

}
