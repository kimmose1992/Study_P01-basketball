package com.study.basketball.cm.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.basketball.cm.vo.CmCodeVO;

@Repository
public class CmComDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final String NAMESPACE = "cm.com.";
	
	/**
	 * @title   : 공통코드 목록 조회
	 * @author	: 김모세
	 * @create	: 2022.06.14
	 */
	public List<CmCodeVO> comCodeList(CmCodeVO cmCodeVO) {
		return sqlSession.selectList(NAMESPACE + "comCodeList", cmCodeVO);
	}

}
