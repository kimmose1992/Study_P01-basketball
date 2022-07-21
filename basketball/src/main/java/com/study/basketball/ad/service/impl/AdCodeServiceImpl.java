package com.study.basketball.ad.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.basketball.ad.domain.dto.AdCodeDetailDTO;
import com.study.basketball.ad.domain.dto.AdCodeMasterDTO;
import com.study.basketball.ad.domain.entity.AdCodeDetailEntity;
import com.study.basketball.ad.domain.entity.AdCodeMasterEntity;
import com.study.basketball.ad.repository.AdCodeDetailRepository;
import com.study.basketball.ad.repository.AdCodeMasterRepository;
import com.study.basketball.ad.service.AdCodeService;

/**
 * @title	: [관리자] 공통코드 Service 구현 클래스
 * @author	: 김모세
 * @create	: 2022.07.20
 */
@Service
public class AdCodeServiceImpl implements AdCodeService {

	private static final Logger logger = LoggerFactory.getLogger(AdCodeServiceImpl.class);
	
	@Autowired
	private AdCodeMasterRepository adCodeMasterRepository;

	@Autowired
	private AdCodeDetailRepository adCodeDetailRepository;
	
	/**
	 * @title   : 마스터 코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.07.20
	 */
	@Override
	public List<AdCodeMasterDTO> getCodeList() throws Exception {
		// 마스터 코드 목록 조회
		List<AdCodeMasterEntity> codeMasterEntityList = adCodeMasterRepository.findAllByUseYn("Y");
		
		List<AdCodeMasterDTO> codeMasterDTOList = new ArrayList<AdCodeMasterDTO>();
		codeMasterEntityList.forEach(codeMasterEntity -> {
			codeMasterDTOList.add(new AdCodeMasterDTO(codeMasterEntity));
		});
		
		return codeMasterDTOList;
	}

	/**
	 * @title   : 디테일 코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.07.21
	 */
	@Override
	public List<AdCodeDetailDTO> getCodeDetailList(AdCodeDetailDTO adCodeDetailDTO) throws Exception {
		String cdmId = adCodeDetailDTO.getCdmId();
		
		// 디테일 코드 목록 조회
		List<AdCodeDetailEntity> codeDetailEntityList = adCodeDetailRepository.findAllByCdmIdAndUseYn(cdmId, "Y");

		List<AdCodeDetailDTO> codeDetailDTOList = new ArrayList<AdCodeDetailDTO>();
		codeDetailEntityList.forEach(codeDetailEntity -> {
			codeDetailDTOList.add(new AdCodeDetailDTO(codeDetailEntity));
		});
		
		return codeDetailDTOList;
	}

}
