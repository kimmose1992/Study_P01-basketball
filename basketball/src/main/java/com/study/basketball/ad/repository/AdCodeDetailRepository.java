package com.study.basketball.ad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.basketball.ad.domain.entity.AdCodeDetailEntity;

/**
 * @title	: [관리자] 공통코드 디테일 Repository 인터페이스	  
 * @author	: 김모세
 * @create	: 2022.07.20
 */
public interface AdCodeDetailRepository extends JpaRepository<AdCodeDetailEntity, Long> {

}
