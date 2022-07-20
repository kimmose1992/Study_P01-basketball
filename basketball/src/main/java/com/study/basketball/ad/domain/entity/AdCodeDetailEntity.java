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
 * @title	: [관리자] 공통코드 디테일 Entity 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.20
 */
@Entity
@Table(name="P01_CODE_D")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AdCodeDetailEntity extends CmBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long cddSeq;				// SEQ
	
	@Column
	private Long cdmSeq;				// 마스터SEQ
	
	@Column
	private String cdmId;				// 마스터ID
	
	@Column
	private String cddId;				// 코드ID
	
	@Column
	private String cddNm;				// 코드명
	@Column
	private String cddDesc;				// 비고
	@Column
	private int cddSort;				// 순서
	@Column
	private String useYn;				// 사용여부
	@Column
	private String attribute1;			// 속성1
	@Column
	private String attribute2;			// 속성2
	@Column
	private String attribute3;			// 속성3
}
