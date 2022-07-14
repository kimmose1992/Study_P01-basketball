package com.study.basketball.ad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.basketball.ad.domain.entity.AdUserEntity;

/**
 * @title	: [관리자] 사용자 Repository 인터페이스	  
 * @author	: 김모세
 * @create	: 2022.07.14
 */
public interface AdUserRepository extends JpaRepository<AdUserEntity, Long> {

}
