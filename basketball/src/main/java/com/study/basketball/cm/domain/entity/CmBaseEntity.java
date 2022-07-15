package com.study.basketball.cm.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/**
 * @title	: [공통] 공통 Entity 클래스	  
 * @author	: 김모세
 * @create	: 2022.07.15
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CmBaseEntity {

//	@CreatedDate
//	@Column(name = "REG_DT", nullable = false)
//	private LocalDateTime regDt;		// 등록일시
//	
//	@CreatedBy
//	@Column(name = "REG_USER")
//	private Long regUser;				// 등록자
//	
//	@LastModifiedDate
//	@Column(name = "MDF_DT")
//	private LocalDateTime mdfDt;		// 수정일시
//	
//	@LastModifiedBy
//	@Column(name = "MDF_USER")
//	private Long mdfUser;				// 수정자
}
