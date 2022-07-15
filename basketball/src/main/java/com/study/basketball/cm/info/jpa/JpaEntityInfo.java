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
	 * - 대표적인 어노테이션
	 *  > 객체 & 테이블 매핑	: @Entity, @Table
	 *  > 기본 키 매핑 		: @Id
	 *  > 필드 & 컬럼 매핑 	: @Column
	 *  > 연관관계 매핑 	: @ManyToOne, @JoinColumn
	 * 
	 * [Note]
	 * - 기본 생성자 필수 (JPA가 Entity 생성 시, 기본 생성자 사용)
	 * - 저장할 필드에 final 사용 불가
	 * - final 클래스, enum, interface, inner class에는 사용 불가
	 * 
	 * 1) @Entity
	 * - name : JPA에서 사용할 Entity이름 지정 (기본값. 클래스명 : EX. @Entity(name="jpaEntity"))
	 * ================================================================================
	 * ■ Sample Source
	 * @Entity(name="entityName")
	 * public class SampleEntity {
	 * }
	 * ================================================================================
	 * 
	 * 
	 * 
	 * 2) @Table : Entity와 매핑할 테이블 지정
	 * - name 			   : 매핑할 테이블 이름 (기본값. Entity명)
	 * - cataLog		   : DB에서 CataLog 매핑 (기본값. DB명)
	 * - schema			   : DB에서 Schema 매핑
	 * - uniqueConstraints : DDL 생성 시, Unique 제약 조건 생성 (DDL 생성 시에만 사용)
	 * ================================================================================
	 * ■ Sample Source
	 * @Entity
	 * @Table(name="TABLE_NAME", uniqueConstraints = { 
	 *    @UniqueConstraint(name={ "contstraintName" }, columnNames={ "col1", "col2" })
	 * })
	 * public class SampleEntity {
	 * }
	 * ================================================================================
	 * 
	 * 
	 * 
	 * 3) @Column : 객체 필드를 테이블 컬럼에 매핑
	 * - name 			  : 필드와 매핑할 테이블 컬럼 이름 (기본값. 필드명)
	 * - nullable 	      : null 허용여부 설정 (기본값. true(is null) - @Column 사용 시, nullable = false가 안전)
	 * - unique 	      : 한 컬럼에 Unique 조건 적용
	 * - columnDefinition : DB컬럼 정보 및 기본값 설정
	 * - length 		  : 문자길이 제약 설정 (기본값. 255 - String에만 가능)
	 * - percision, scale : BigDemical, BigInteger 타입에서 사용
	 * ================================================================================
	 * ■ Sample Source
	 * @Entity
	 * @Table(name="TABLE_NAME", uniqueConstraints = { 
	 *    @UniqueConstraint(name={ "contstraintName" }, columnNames={ "col1", "col2" })
	 * })
	 * public class SampleEntity {
	 * 
	 *   @Column(name="col1")
	 *   private String col1;
	 *    
	 *   @Column(name="col2")
	 *   private String col2;
	 * }
	 * ================================================================================
	 *  
	 *  
	 *  
	 * 4) @Temporal : 날짜 타입(java.util.Date, java.util.Calendar) 매핑 (기본값. TemporalType 필수 지정)
	 * - TemporalType.DATE      : 날짜, 데이터베이스 data 타입과 매핑 ( 2021-07-06 )
	 * - TemporalType.TIME      : 시간, 데이터베이스 time 타입과 매핑 ( 15:27:33 )
	 * - TemporalType.TIMESTAMP : 날짜와 시간, 데이터베이스 timestamp 타입과 매핑 ( 2021-07-06 15:27:33 )
	 * ※ @Temporal 을 생략 시, timestamp로 타입으로 정의
	 * ================================================================================
	 * ■ Sample Source
	 * @Entity
	 * public class SampleEntity {
	 * 
	 *   @Temporal(TemporalType.DATE)
	 *   private Date colDate;
	 *    
	 *   @Temporal(TemporalType.TIME)
	 *   private Date colTime;
	 *    
	 *   @Temporal(TemporalType.TIMESTAMP)
	 *   private Date colTimestamp;
	 * }
	 * ================================================================================
	 *  
	 *  
	 *  
	 * 5) @Lob : BLOB(문자 기반), CLOB(바이너리 기반) 타입 매핑
	 * - BLOB : byte[]
	 * - CLOB : String, char[] 
	 * ================================================================================
	 * ■ Sample Source
	 * @Entity
	 * public class SampleEntity {
	 * 
	 *   @Lob
	 *   @Column(name="colBlob", columnDefinition="BLOB")
	 *   private byte[] colBlob;
	 *    
	 *   @Lob
	 *   @Column(name="colClob", columnDefinition="CLOB")
	 *   private String colClob;
	 * }
	 * ※ columnDefinition 선언하지 않아도 @Lob이 변수 타입에 따라 자동 구분
	 * ================================================================================
	 * 
	 * 
	 * 
	 * 6) @Transient : 필드에 매핑하지 않음
	 * - DB 관련된 작업하지 않음
	 * - 객체 임시 값 보관용으로 사용
	 * ================================================================================
	 * ■ Sample Source
	 * @Entity
	 * public class SampleEntity {
	 * 
	 *   @Transient
	 *   private String col1;
	 * }
	 * ================================================================================
	 * 
	 * 
	 * 
	 * 7) @Access : JPA가 Entity에 접근하는 방식을 지정
	 * - AccessType.FIELD	 : 필드 접근 (직접 접근)
	 * - AccessType.PROPERTY : 프로퍼티 접근 (Getter 사용)
	 * ※ @Access 를 설정하지 않은 경우, @Id의 위치를 기준으로 접근 방식 결정
	 * ================================================================================
	 * ■ Sample Source
	 * ▷ [Case1]: 기본 사용
	 * @Entity
	 * @Access(AccessType.FIELD)
	 * public class SampleEntity {
	 * 
	 *   @Id
	 *   private String id;
	 * }
	 * 
	 * ▷ [Case2]: @Access 를 설정하지 않은 경우
	 * @Entity
	 * public class SampleEntity {
	 * 
	 *   @Id
	 *   private String id;
	 * }
	 * ※ @Id의 위치가 필드에 선언되어 있으므로 @Access(AccessType.FIELD)와 동일함
	 * 
	 * ▷ [Case3]: @Access 를 설정하지 않은 경우
	 * @Entity
	 * public class SampleEntity {
	 * 
	 *   private String id;
	 *    
	 *   @Id 
	 *   public String getId(){
	 *     return id;
	 *   }   
	 * }
	 * ※ @Id의 위치가 프로퍼티에 선언되어 있으므로 @Access(AccessType.PROPERTY)와 동일함
	 * ================================================================================
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
	 *  
	 * ※ 기본키 생성 전략 사용을 위해서는 hibernate.use-new-id-generator-mappings 옵션을 반드시 true로 설정해주어야 함
	 *  > Spring Boot 1.5 : 기본값. false
	 *  > Spring Boot 2.0 : 기본값. true
	 *  > 2.0 이후 버전부터는 기본값이 true이기 때문에 해당 옵션 설정을 Skip해도 되지만, 사용하지 않을 경우 아래와 같이 설정한다.
	 *   → [application.properties] : spring.jpa.hibernate.use-new-id-generator-mappings=false 
	 * ================================================================================
	 * ■ Sample Source
	 * @Entity
	 * public class SampleEntity {
	 * 
	 *   @Id
	 *   @GeneratedValue(strategy = GenerationType.IDENTITY)
	 *   private String id;
	 * }
	 * ================================================================================
	 */ 
}
