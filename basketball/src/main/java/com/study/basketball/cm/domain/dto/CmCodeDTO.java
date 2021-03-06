package com.study.basketball.cm.domain.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @title	: [공통] 코드 DTO 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.14
 */
@Getter
@Setter
public class CmCodeDTO {

	/** 코드 마스터 테이블 */
	private int cdmSeq;
	private String cdmId;
	private String cdmNm;
	private String cdmDesc;
	private String useYn;
	
	/** 코드 디테일 테이블 */
	private int cddSeq;
	private String cddId;
	private String cddNm;
	private String cddDesc;
	private int cddSort;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	
	/** 입출력 변수 */
	private String comboType;
	private String comboId;
	
	/** 리스트 변수 */
	private List<CmCodeDTO> cmCodeDTOList;
}
