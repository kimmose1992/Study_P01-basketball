package com.study.basketball.ur.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.basketball.ur.dto.UrLoginDTO;

/**
 * @title	: [사용자] 로그인 DAO 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.08
 */
@Repository
public class UrLoginDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final String NAMESPACE = "ur.login.";
	
	/**
	 * @title   : 공통코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.06.14
	 */
	public int signUpSave(UrLoginDTO urLoginDTO) {
		return 0;
	}

}
