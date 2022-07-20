package com.study.basketball.ad.domain.dto;

import com.study.basketball.ad.domain.entity.AdCodeMasterEntity;
import com.study.basketball.cm.domain.dto.CmBaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @title	: [관리자] 공통코드 마스터 DTO 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.20
 */
@Getter
@Setter
@NoArgsConstructor
public class AdCodeMasterDTO extends CmBaseDTO {

	/** 사용자 테이블 */
	private Long cdmSeq;		// SEQ
	private String cdmId;		// 코드ID
	private String cdmNm;		// 코드명
	private String cdmDesc;		// 비고
	private String useYn;		// 사용여부
	
	public AdCodeMasterDTO(AdCodeMasterEntity adCodeMasterEntity) {
		this.cdmSeq 	= adCodeMasterEntity.getCdmSeq();
		this.cdmId 		= adCodeMasterEntity.getCdmId();
		this.cdmNm 		= adCodeMasterEntity.getCdmNm();
		this.cdmDesc	= adCodeMasterEntity.getCdmDesc();
		this.useYn 		= adCodeMasterEntity.getUseYn();
	}
}
