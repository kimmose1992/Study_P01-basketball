package com.study.basketball.ad.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.study.basketball.cm.domain.entity.CmBaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @title	: [관리자] 공통코드 마스터 Entity 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.20
 */
@Entity
@Table(name="P01_CODE_M")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AdCodeMasterEntity extends CmBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long cdmSeq;				// SEQ
	
	@Column
	private String cdmId;				// 코드ID
	
	@Column
	private String cdmNm;				// 코드명
	
	@Column
	private String cdmDesc;				// 비고
	
	@Column
	private String useYn;				// 사용여부
}
