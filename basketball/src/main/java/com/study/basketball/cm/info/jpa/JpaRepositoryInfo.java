package com.study.basketball.cm.info.jpa;

public class JpaRepositoryInfo {

	/************************************************************************
	 * ■ Repository
	 ************************************************************************/
	/* 
	 * - Entity에서 생성된 DB접근 메소드(EX. findAll)를 사용하기 위한 인터페이스
	 * - Entity로 선언된 DB구조를 어떻게 사용할지 정의하는 계층 
	 * - JpaRepository를 상속받아 정의된 메소드 사용
	 */

	/************************************************************************
	 * ■ JpaRepository
	 ************************************************************************/
	/* 
	 * - Spring Data JPA의 Repository 인터페이스 구현체
	 * - super : CrudRepository<T,ID>, PagingAndSortingRepository<T,ID>, QueryByExampleExecutor
	 * - EntityManager를 포함
	 * - 상속 시, 사용될 Entity 클래스와 ID값 선언 : JpaRepository<T, ID
	 *  > EX. public interface EntityRepository extends JpaRepository<Entity, Long>
	 *  
	 *  [Method]
	 *  - save()	: 레코드 저장 (insert, update)
	 *  - findOne()	: PK로 레코드 조회
	 *  - findAll()	: 전체 레코드 조회 및 정렬(sort), 페이징(paging) 가능
	 *  - count()	: 레코드 갯수
	 *  - delete()	: 레코드 삭제
	 */

	/************************************************************************
	 * ■ EntityManager & EntityManagerFactory
	 ************************************************************************/	
	/* 
	 * [EntityManagerFactory]
	 * - EntityManager 생성
	 * - Thread 공유 가능 (Thread Safe 지원)
	 * - Hibernate 에서는 SessionFactory 로 명칭
	 * 
	 * [EntityManager]
	 * - Entity를 저장하는 메모리 데이터베이스 개념
	 * - Entity의 CRUD 작업 관리
	 * - Thread 공유 불가 (Thread Safe 미지원 - @PersistenceContext 어노테이션 추가 시 지원)
	 * - Hibernate 에서는 Session 으로 명칭
	 * 
	 * [Note]
	 * ※ Thread Safe : Multi Thread 프로그래밍 개념
	 * - 변수, 함수, 객체가 여러 Thread에서 동시에 접근이 이루어져도 프로그램 실행의 문제가 없음을 의미
	 * ※ @PersistenceContext : 영속성 컨텍스트
	 * - Entity를 영구 저장하는 환경
	 * - EntityManager 생성 시, 한개 생성
	 */	
	
	/************************************************************************
	 * ■ Spring Data JPA
	 ************************************************************************/
	/* 
	 * - Spring에서 JPA 사용을 지원하는 모듈
	 * - JpaRepository 제공
	 * - JPA에 접근하기 위한 추상화 구현 개념 
	 * - GenericDao 구현체 제공 : JPA 쿼리 생성
	 * 
	 * [Note]
	 * ※ 반드시 Hibernate와 같은 JPA구현체 필요
	 */
	
	/************************************************************************
	 * ■ Hibernate
	 ************************************************************************/
	/*
	 * - JPA 인터페이스 실제 구현체
	 * - 내부적으로 JDBC API 사용
	 * - 메소드 호출만으로 쿼리 작성 및 수행 가능 (메소드 호출 방식은 직접 작성한 SQL보단 성능상 좋지 않음)
	 * - 테이블 컬럼이 변경되었을 때, 테이블 관련된 DAO, SQL, 결과 대신 수행 (유지보수 좋음)
	 * - JPQL, NativeQuery 지원 (메소드 호출 쿼리는 한계가 있음 EX. 복잡한 통계 쿼리 등)
	 * - SQL의 의존되지 않는 객체 중심 개발 가능
	 */
}
