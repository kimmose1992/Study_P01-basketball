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
	
	/************************************************************************
	 * ■ Entity 관련 Lombok 정보
	 ************************************************************************/
	/*
	 * 1) @Getter, @Setter
	 * - @Getter : 모든 필드에 getter 메소드 생성
	 * - @Setter : 모든 필드에 setter 메소드 생성
	 * 
	 * [NOTE]
	 * 1. @Setter 사용 관련
	 * - 실제 프로젝트에서는 일반적으로 Entity에 @Setter 사용을 지양함 → 객체 값에 대한 일관성 불안정
	 * 
	 * ================================================================================
	 * ■ Sample Source
	 * @Getter
	 * @Setter
	 * public class SampleEntity {
	 * 
	 *   private String col1;
	 * }
	 * ================================================================================
	 * 
	 * 
	 * 
	 * 2) @NoArgsConstructor, @AllArgsConstructor, @RequiredArgsConstructor
	 * - Entity는 (기본) 생성자를 필수로 생성해야 한다.
	 * - @NoArgsConstructor	      : 파라미터를 받지 않는 기본 생성자  
	 * - @AllArgsConstructor      : 모든 필드를 파라미터로 받는 생성자
	 * - @RequiredArgsConstructor : final or @NotNull 어노테이션이 붙은 필드를 파라미터로 받는 생성자
	 * 
	 * [NOTE]
	 * 1. @NoArgsConstructor(access = AccessLevel.PROTECTED)
	 * - Entity와 DTO 선언 시, 자주 사용되는 구조 
	 * - 무분별한 객체의 생성을 제한하고 체크하기 위한 전략으로 사용
	 * 
	 * ※ 모든 필드에 값이 있어야 생성된다는 전제
	 * - EX1) @Setter 사용 시, 값이 누락될 수 있어 불완전함
	 * @Getter
	 * @Setter
	 * @NoArgsConstructor
	 * public class SampleEntity {
	 * 
	 *   private String col1;
	 *   private String col2;
	 * }
	 * - EX2) 지정된 생성자로만 객체를 선언할 수 있으므로 값이 누락될 수 없어 완전함
	 * @Getter
	 * @NoArgsConstructor(access = AccessLevel.PROTECTED)
	 * public class SampleEntity {
	 * 
	 *   private String col1;
	 *   private String col2;
	 *   
	 *   public SampleEntity(col1, col2) {
	 *   	this.col1 = col1;
	 *   	this.col2 = col2;
	 *   }
	 * }
	 * 
	 * ================================================================================
	 * ■ Sample Source
	 * @NoArgsConstructor
	 * @AllArgsConstructor
	 * public class SampleEntity {
	 * 
	 *   private String col1;
	 * }
	 * ================================================================================
	 * 
	 * 
	 * 
	 * 3. @Builder (Builder Pattern)
	 * - 디자인 패턴 중 하나로, 생성과 표현의 분리 개념 → 생성자의 인자가 많은 경우 고려
	 * - 메소드체이닝 기법으로 값을 설정 후, build() 메소드로 객체를 생성하여 객체를 리턴받는다.
	 * - build() 이후 멤버변수의 값을 변경하는 방법은 리플렉션 기법(동적메소드 변경)외에는 존재하지 않는다. (안된다고 보면 될듯)
	 * 
	 * [NOTE]
	 * ※ Target Type에 따른 Builder 동작방식
	 * 1. Class인 경우
	 * - 생성자가 없는 경우 : 모든 멤버변수를 매개변수로 받는 기본 생성자 생성
	 * - 생성자가 있는 경우 : 생성자를 추가로 생성하지 않음
	 * - @Builder 모든 멤버변수를 매개변수로 받는 생성자가 필요하므로 @NoArgsConstructor만 있는 경우, 컴파일 에러 발생
	 *  > @AllArgsConstructor 추가 필요
	 * 2. 생성자인 경우
	 * - 생성자별로 정의하기 때문에 @NoArgsConstructor만 선언해도 된다.
	 * 
	 * ※ 객체 생성 패턴 과정 (점층적 생성자 패턴 → 자바 빈즈 패턴 → 빌더 패턴)
	 * 1. 점층적 생성자 패턴
	 * - 객체 생성 시, 생성자에 매개변수를 받아서 생성
	 * - 선택적으로 인자를 받기 위해 추가적으로 생성자 생성
	 * - (단점) 인자 값이 많아질수록 생성자가 많아짐
	 * - (단점) 생성자 선언 시, 매개변수의 정보를 알수 없어 파악이 어렵다.
	 * 
	 * 2. 자바 빈즈 패턴
	 * - 점층적 생성자 패턴(1)의 단점을 보완한 패턴
	 * - 매개변수의 정보를 파악할 수 있게 되어 가독성이 어느정도 해결됨
	 * - (단점) 코드량이 늘어남
	 * - (단점) 객체의 일관성이 깨짐
	 * 
	 * 3. 빌더 패턴
	 * - 점층적 생성자 패턴(1), 자바 빈즈 패턴(2)의 모든 단점을 보완한 패턴
	 * - 점층적 생성자 패턴(1) 보완
	 *  > 불필요한 생성자 제거
	 *  > 데이터의 순서 상관없이 객체 생성 가능
	 *  > 명시적 선언으로 매개변수의 정보 파악 가능
	 * - 자바 빈즈 패턴(2) 보완
	 *  > Setter 메소드가 없으므로 변경 불가능함
	 *  > 값 설정 후 객체를 생성하므로 객체 일관성이 유지됨
	 *  
	 * ※ 리플렉션(Reflection) 기법
	 * - 구체적인 클래스 타입을 알지 못하더라도 그 클래스의 메서드, 타입, 변수들에 접근할 수 있도록 해주는 자바 API
	 * - 컴파일 시간이 아닌 실행 시간에 동적으로 특정 클래스의 정보를 추출할 수 있는 프로그래밍 기법
	 * - 컴파일이 아닌 런타임 시점에 처리
	 * - EX. Class cls = Test.class (다음과 같은 방식으로 받아 cls에서 정보를 추출하고 변경하는 방식)
	 */
}
