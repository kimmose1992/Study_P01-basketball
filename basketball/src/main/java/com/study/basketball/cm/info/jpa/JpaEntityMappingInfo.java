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
	 * 2. 1	: N	→ @OneToMany	: 일반적으로 참조 당하는 Entity에서 사용 (mappedBy="참조하는 Entity의 변수 이름") 설정
	 * 3. N	: 1	→ @ManyToOne	: 일반적으로 참조 하는 Entity에서 사용
	 * 4. N : M → @ManyToMany
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
	 * - 기본 전략값이 Default 이므로 변경하기 위해서는 직접 FetchType을 지정해주어야 한다.
	 * - @OneToOne는 FetchType.LAZY가 제대로 동작하지 않는다.
	 * - @ManyToMany 는 사용을 지양한다.
	 * ※ 실무 권장 Tip
	 * - 모든 연관관계에서 지연로딩(FetchType.LAZY) 사용 > 즉시로딩(FetchType.EAGER) 지양
	 * - JPQL fetch 조인 or Entity 그래프 기능 사용
	 * 
	 * 1) FecthType.EAGER (즉시 로딩)
	 * - Entity를 조회할 때, 연관된 Entity를 즉시 한 번에 조회한다. 실제 객체가 사용되지 않더라도 조회를 해온다.
	 * - (주의) 상상하지 못한 SQL문이 실행될 수 있음
	 * 
	 * 2. FetchType.LAZY (지연 로딩)
	 * - Entity를 조회할 때, 연관된 Entity는 실제 사용 시점에 조회한다.
	 * - 실제 객체가 사용되는 시점까지 조회를 미룬다.
	 * 
	 * ※ FetchType.LAZY 를 권장함
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
	 */

	/************************************************************************
	 * ■ JPA N+1 문제
	 ************************************************************************/
	/*
	 * - Entity 연관 관계에서 발생하는 이슈
	 * - 연관 관계가 설정된 Entity를 조회하여 조회된 갯수만큼 추가로 연관 관계 쿼리가 발생하는 현상
	 * - 일반 Join은 Entity의 연관 관계를 무시하고 해당 Entity 기준으로 조회하기 때문에 발생
	 * - 특정 Entity만 영속화 하기 때문에, 연관 관계의 Entity에 대해서는 추가로 쿼리문을 호출하게 된다.
	 * 
	 * [해결방안]
	 * 1) Fetch Join
	 * ※ Example
	 *  @Query("select o from catOwner o join fetch o.cats")
	 *  List<CatOwner> findAllJoinFetch();
	 *  
	 * - 조회 대상 Entity 포함, 연관된 Entity에 도 함께 Select하여 '모두 영속화' 시킴
	 * - 모두 영속화 되어 있으므로 추가로 쿼리를 호출하지 않기 때문에 N+1 문제가 해결됨
	 * - 연관 관계의 쿼리를 INNER JOIN으로 호출
	 * ※ 단점
	 * - 데이터 호출 시점에 모든 연관 관계 데이터를 가져오므로 FetchType.LAZY는 의미가 없어진다.
	 * - 페이징 쿼리를 사용할 수 없다. 하나의 쿼리 문으로 가져오기 때문.
	 * 
	 * 2) EntityGraph
	 * ※ Example
	 *  @EntityGraph(attributePaths = "cats")
	 *  @Query("select o from catOwner o")
	 *  List<CatOwner> findAllEntityGraph();
	 *  
	 * - attributePaths : 바로 가져올 필드명 지정 → FecthType.EAGER 호출
	 * - 연관 관계의 쿼리를 OUTER JOIN으로 호출
	 * 
	 * 3) 주의사항
	 * - 중복 데이터 관리가 필요하다. (Set 사용 및 distinct 등 사용하여 중복 데이터가 없도록 해야한다.)
	 * 
	 * [Note]
	 * - FetchType 설정으로 인해 발생한다고 생각하는 오해 관련
	 *  > FetchType은 초기 데이터 로드 시점인지 실제 데이터 사용 시점인지에 대한 차이만 있으므로 결국엔 N+1 문제가 발생한다.
	 * 
	 * 
	 * 
	 * ================================================================================
	 * ■ Sample Source (※ 고양이 집사와 고양이의 관계로 샘플 소스 설명)
	 * 1) 고양이 집사 Entity
	 * @Entity
	 * public class CatOwner {
	 *     @Id
	 *     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 *     private Long id;
	 *     private String name;
	 *     
	 *     @OneToMany(mappedBy = "catOwner", fetch = FetchType.EAGER)
	 *     private Set<Cat> cats = new LinkedHashSet<>();
	 * }
	 * 
	 * 2) 고양이 Entity
	 * public class Cat {
	 *     @Id
	 *     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 *     private Long id;
	 *     private String name;
	 *     
	 *     @ManyToOne
	 *     private CatOwner catOwner;
	 * }
	 * 
	 * 3) 테스트 (※ 고양이 집사는 10명이고 각각 10마리씩 키우고 있다는 시나리오)
	 * - catOwnerRepo.findAll() 수행 → 10건 조회 → 추가로 결과 갯수(10) 만큼의 고양이 조회 쿼리 수행 (N+1 문제 발생) 
	 * ================================================================================
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
	 * - 프록시 객체는 실제 객체를 상속받아 구현되었으므로 instanceOf를 통해 타입 비교한다.
	 * - 영속성 컨텍스트에 실제 객체가 먼저 있는 경우, getReference()를 호출해도 프록시 객체가 아닌 실제 객체를 반환한다.
	 * - 프록시 객체가 호출되어 실제 객체를 생성하는 것을 '프록시 초기화' 라고 한다.
	 * 
	 * ※ 프록시 초기화
	 * - 처음 사용 시 한번만 초기화된다.
	 * - 초기화 시, 실제 객체가 되는 것이 아닌 프록시 객체의 target에 실제 객체가 매핑되어 접근이 가능해지는 것을 의미한다.
	 * - 초기화 이후 호출 시, 처음 호출된 객체를 반복한다. (추가로 DB 쿼리를 실행하지 않는다)
	 * 
	 * ※ EntityManager 제공 메소드
	 * - find() 		: 실제 Entity 객체를 조회하는 메소드
	 * - getReference() : 가짜(프록시) Entity 객체를 조회하는 메소드
	 *  
	 * ※ 프록시 확인
	 * - 초기화 여부 확인       : PersistenceUnitUtil.isLoaded(Object entity)
	 * - 프록시 클래스 여부 확인  : entity.getClass().getName() → ..HibernateProxy.. 과 같은 결과 값 출력
	 * - 프록시 객체 강제 초기화  : Hibernate.initialize(entity)
	 */
}
