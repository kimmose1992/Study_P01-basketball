package com.study.basketball.cm.info.jpa;

public class JpaEntityInfo {

	/************************************************************************
	 * ■ Entity
	 ************************************************************************/
	/* 
	 * - 테이블과의 매핑
	 * - @Entity가 붙은 클래스는 JPA에서 관리
	 * - JpaRepository를 상속받아 정의된 메소드 사용
	 * 
	 * @Entity
	 * - Name : JPA에서 사용할 Entity이름 지정 (기본값. 클래스명 : EX. @Entity(name="jpaEntity"))
	 * 
	 * @Table
	 * - Name 			   : 매핑할 테이블 이름 (기본값. Entity명)
	 * - CataLog		   : DB에서 CataLog 매핑 (기본값. DB명)
	 * - Schema			   : DB에서 Schema 매핑
	 * - uniqueConstraints : DDL 생성 시, Unique 제약 조건 생성 (DDL 생성 시에만 사용)
	 * 
	 * [Note]
	 * - 기본 생성자 필수 (JPA가 Entity 생성 시, 기본 생성자 사용)
	 * - 저장할 필드에 final 사용 불가
	 * - final 클래스, enum, interface, inner class에는 사용 불가
	 */

	/************************************************************************
	 * ■ 기본키 매핑 방식
	 ************************************************************************/
	/*
	 * - 영속성 컨텍스트는 Entity를 식별자 값으로 구분
	 * ※ Entity를 영속 상태로 만들기 위해서는 식별자 값이 반드시 필요
	 * 
	 * @GeneratedValue 기본키 생성 전략 
	 * 1) 직접 할당
	 * - 기본키를 직접 할당
	 * - em.persist()를 호출하기 전, 직접 식별자 값 할당 (미할당시 오류 발생)
	 * 
	 * 2) 자동 할당 (strategy = GenerationType.${TYPE})
	 * - 대리키 사용 방식
	 * - ${TYPE}
	 *  > IDENTITY	: 기본 키 생성을 데이터베이스에 위임 (= MySQL, MariaDB)
	 *  > SEQUENCE  : 기본 키 생성을 시퀀스에 위임 (= Oracle, PostgreSQL, DB2, H2)
	 *  > TABLE   	: 기본 키 생성 테이블을 별도 생성 (= 모든 데이터베이스 대상)
	 *  > AUTO  	: 선택한 DB에 맞게 TYPE을 자동으로 설정 (Default)
	 */ 
}
