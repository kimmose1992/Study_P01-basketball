package com.study.basketball.ad.domain.dto;

import com.study.basketball.ad.domain.entity.AdCodeDetailEntity;
import com.study.basketball.cm.domain.dto.CmBaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @title	: [관리자] 공통코드 디테일 DTO 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.20
 */
@Getter
@Setter
@NoArgsConstructor
public class AdCodeDetailDTO extends CmBaseDTO {

	/** 사용자 테이블 */
	private Long cddSeq;			// SEQ
	private Long cdmSeq;			// 마스터SEQ
	private String cdmId;			// 마스터ID
	private String cddId;			// 코드ID
	private String cddNm;			// 코드명
	private String cddDesc;			// 비고
	private int cddSort;			// 순서
	private String useYn;			// 사용여부
	private String attribute1;		// 속성1
	private String attribute2;		// 속성2
	private String attribute3;		// 속성3
	
	public AdCodeDetailDTO(AdCodeDetailEntity adCodeDetailEntity) {
		this.cddSeq 	= adCodeDetailEntity.getCddSeq();
		this.cdmSeq 	= adCodeDetailEntity.getCdmSeq();
		this.cdmId 		= adCodeDetailEntity.getCdmId();
		this.cddId 		= adCodeDetailEntity.getCddId();
		this.cddNm 		= adCodeDetailEntity.getCddNm();
		this.cddDesc	= adCodeDetailEntity.getCddDesc();
		this.cddSort	= adCodeDetailEntity.getCddSort();
		this.useYn 		= adCodeDetailEntity.getUseYn();	
		this.attribute1	= adCodeDetailEntity.getAttribute1();	
		this.attribute2	= adCodeDetailEntity.getAttribute2();	
		this.attribute3	= adCodeDetailEntity.getAttribute3();	
	}
}
