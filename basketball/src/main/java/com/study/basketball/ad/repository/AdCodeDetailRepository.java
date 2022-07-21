package com.study.basketball.ad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.basketball.ad.domain.entity.AdCodeDetailEntity;

/**
 * @title	: [관리자] 공통코드 디테일 Repository 인터페이스	  
 * @author	: 김모세
 * @create	: 2022.07.20
 */
public interface AdCodeDetailRepository extends JpaRepository<AdCodeDetailEntity, Long> {

	/**
	 * @title   : 디테일 코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.07.21
	 */
	List<AdCodeDetailEntity> findAllByCdmIdAndUseYn(String cdmId, String useYn) throws Exception;

}
