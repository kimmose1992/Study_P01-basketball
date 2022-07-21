package com.study.basketball.ad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.basketball.ad.domain.entity.AdCodeMasterEntity;

/**
 * @title	: [관리자] 공통코드 마스터 Repository 인터페이스	  
 * @author	: 김모세
 * @create	: 2022.07.20
 */
public interface AdCodeMasterRepository extends JpaRepository<AdCodeMasterEntity, Long> {

	/**
	 * @title   : 마스터 코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.07.21
	 */
	List<AdCodeMasterEntity> findAllByUseYn(String useYn) throws Exception;

}
