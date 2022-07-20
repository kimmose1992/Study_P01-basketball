package com.study.basketball.cm.info.jpa;

public class JpaEntityMappingInfo {

	/************************************************************************
	 * ■ DB Mapping & Foreign Key
	 ************************************************************************/
	/*
	 * - SQL패러다임을 JAVA에서 객체 패러다임으로 구현
	 * ※ 사용자와 주문품목 목록의 관계 설정으로 정리
	 * 
	 * 1) @OneToOne → 1 : 1
	 * ================================================================================
	 * ■ Sample Source
	 * @Entity
	 * public class SampleOrderItem {
	 *     @Id
	 *     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 *     private Long itemId;
	 *     
	 *     @ManyToOne(fetch = FetchType.LAZY)
	 *     @JoinColumn(name = "userId")
	 *     private SampleUser userId;
	 *     
	 *     @ManyToOne(fetch = FetchType.LAZY)
	 *     @JoinColumn(name = "itemId")
	 *     private SampleItem itemId;
	 * }
	 * 
	 * @Entity
	 * public class SampleUser {
	 *     @Id
	 *     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 *     private Long userId;
	 *     private String username;
	 *     
	 *     @OneToMany(mappedBy = "user")
	 *     private List<SampleOrderItem> orderItems = new ArrayList<>();
	 * }
	 * ================================================================================
	 * 
	 * [JPA 테이블 연관 관계 구현]
	 * 1. 1 : 1	→ @OneToOne
	 * 2. 1	: N	→ @OneToMany
	 * 2. N	: 1	→ @ManyToOne 
	 */
	
	/************************************************************************
	 * ■ FetchType
	 ************************************************************************/
	/*
	 * - 하나의 Entity를 조회 시, 연관관계의 Entity를 어떻게 조회할 것인지에 대한 설정
	 * 
	 * [NOTE]
	 * ※ FetchType 기본 전략
	 * 1. FetchType.EAGER : @ManyToOne, @OneToOne
	 * 2. FetchType.LAZY  : @OneToMany, @ManyToMany
	 * 
	 * 
	 * 
	 * 1) FecthType.EAGER (즉시 로딩)
	 * - Entity를 조회할 때, 연관된 Entity를 즉시 한 번에 조회한다. 실제 객체가 사용되지 않더라도 조회를 해온다.
	 * ================================================================================
	 * ■ Sample Source
	 * @Entity
	 * public class SampleEntity {
	 *     @Id
	 *     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 *     private Long id;
	 *     
	 *     @Column(name = "col1")
	 *     private String col1;
	 *     
	 *     @ManyToOne(fetch = FetchType.EAGER)
	 *     @JoinColumn(name = "col2")
	 *     private JoinEntity joinEntity;
	 * }
	 * 
	 * public static void eager(EntityManager entityManager) {
	 *     SampleEntity sampleEntity = entityManager.getReference(SampleEntity.class, 1);
	 *     JoinEntity joinEntity = sampleEntity.getJoinEntity();
	 *     
	 *     System.out.println(sampleEntity.getCol1());
	 *     System.out.println(JoinEntity.getCol2());
	 * }
	 * 
	 * 1) SampleEntity만 find() 메소드를 호출해도 JoinEntity 까지 조회함
	 * 2) Join이 발생하는데, 기본적으로 Outer Join으로 수행 → 외래키가 Null이 허용되기 때문
	 * 3) nullable = false 옵션을 추가하여 Inner Join으로 변경 가능
	 *  > EX. @JoinColumn(name = "col2", nullable = false) 
	 * ================================================================================
	 * 
	 * 2. FetchType.LAZY (지연 로딩)
	 * - Entity를 조회할 때, 연관된 Entity는 실제 사용 시점에 조회한다.
	 * - 실제 객체가 사용되는 시점까지 조회를 미룬다.
	 * 
	 * ※ FetchType.LAZY 를 권장함
	 */
	
	/************************************************************************
	 * ■ JPA 프록시
	 ************************************************************************/
	/*
	 * - DB를 조회하지 않고 생성된 가짜 Entity 객체를 의미
	 * - DB를 조회를 미루는 FetchType.LAZY (지연 로딩) 과 함께 사용됨
	 * - 실제 Entity 객체를 사용한 시점에 DB 쿼리가 수행된다.
	 * - Hibernate에서 내부적으로 실제 클래스를 상속받아 구현한 가짜(프록시) 객체
	 * - 사용자는 진짜 객체인지 프록시 객체인지 구분할 필요가 없다.
	 * - 프록시 객체는 실제 객체의 참조(target) 을 보관한다.
	 * - 프록시 객체를 호출하는 시점에 실제 객체를 호출한다.
	 * - 프록시 객체가 호출되어 실제 객체를 생성하는 것을 '프록시 초기화' 라고 한다.
	 *  > 처음 사용 시 한번만 초기화된다.
	 *  > 초기화 시, 실제 객체가 되는 것이 아닌 프록시 객체의 target 값이 채워지는 것을 의미한다. (타입 비교 시, instanceOf 권장)
	 * - 영속성 컨텍스트에 실제 객체가 있는 경우, getReference()를 호출해도 프록시 객체가 아닌 실제 객체를 반환한다.
	 * 	 * - EntityManager 제공 메소드
	 *  > find() 		 : 실제 Entity 객체를 조회하는 메소드
	 *  > getReference() : 가짜(프록시) Entity 객체를 조회하는 메소드 
	 */
}
