package com.study.basketball.ad.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @title	: [관리자] 사용자 Entity 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.14
 */
@Entity
@Table(name="P01_USER_M")
public class AdUserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_SEQ")
	private Long userSeq;
}
