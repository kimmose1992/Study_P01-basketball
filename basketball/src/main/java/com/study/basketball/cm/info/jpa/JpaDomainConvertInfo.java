package com.study.basketball.cm.info.jpa;

public class JpaDomainConvertInfo {

	/************************************************************************
	 * ■ Entity to DTO
	 ************************************************************************/
	/*
	 * 1) 생성자 사용
	 * - Entity를 생성자로 받아 값 설정
	 * ================================================================================
	 * ■ Sample Source
	 * @Getter
	 * @Setter
	 * public class SampleDTO {
	 * 
	 *     private String col1;
	 *     private String col2;
	 *     
	 *     public SampleDTO(SampleEntity sampleEntity) {
	 *         this.col1 = sampleEntity.getCol1();
	 *         this.col2 = sampleEntity.getCol2();
	 *     }
	 * }
	 * ================================================================================
	 * 
	 * 
	 * 
	 * 2) ModelMapper 사용 (Object 간의 필드값을 자동으로 매핑해주는 라이브러리)
	 * ================================================================================
	 * ■ Sample Source
	 * ModelMapper modelMapper = new ModelMapper();
	 * 
	 * SampleDTO sampleDto = modelMapper.map(sampleEntity, SampleDTO.class);
	 * ================================================================================
	 * 
	 * 
	 * 
	 * 3) Domain 매핑 클래스 사용
	 * - 같은 성격의 DTO와 Entity의 Convert 메소드를 한번에 관리 
	 * ================================================================================
	 * ■ Sample Source
	 * public class SampleMapper {
	 * 
	 *     public SampleDTO toDto(SampleEntity sampleEntity) {
	 *         SampleDTO sampleDto = new SampleDTO();
	 *         sampleDto.setCol1(sampleEntity.getCol1());
	 *         sampleDto.setCol2(sampleEntity.getCol2());
	 *         
	 *         return sampleDto;
	 *     }
	 *
	 *     public SampleEntity toEntity(SampleDTO sampleDto) {
	 *         return SampleEntity.builder().sampleDto(sampleDto).build();
	 *     }
	 * }
	 * 
	 * @Entity
	 * @NoArgsConstructor(access = AccessLevel.PROTECTED)
	 * public class SampleEntity {
	 *     
	 *     @Column
	 *     private String col1;

	 *     @Column
	 *     private String col2;
	 *     
	 *     @Builder
	 *     public SampleEntity(SampleDTO sampleDto) {
	 *     	   this.col1 = sampleDto.getCol1();
	 *     	   this.col2 = sampleDto.getCol2();
	 *     }
	 * }
	 * ================================================================================
	 */	
	
	/************************************************************************
	 * ■ DTO to Entity
	 ************************************************************************/
	/*
	 * 1) toEntity 메소드 생성
	 * ================================================================================
	 * ■ Sample Source
	 * @Getter
	 * @Setter
	 * public class SampleDTO {
	 * 
	 *     private String col1;
	 *     private String col2;
	 *     
	 *     public SampleEntity toEntity() {
	 *     	   SampleDTO sampleDto = new SampleDTO();
	 *         sampleDto.setCol1(col1);
	 *         sampleDto.setCol2(col2);
	 *         
	 *         return SampleEntity.builder().sampleDto(sampleDto).build();
	 *     }
	 * }
	 * ================================================================================
	 * 
	 * 
	 * 
	 * 2) ModelMapper 사용 (Object 간의 필드값을 자동으로 매핑해주는 라이브러리)
	 * ================================================================================
	 * ■ Sample Source
	 * ModelMapper modelMapper = new ModelMapper();
	 * 
	 * SampleEntity sampleEntity = modelMapper.map(sampleDto, SampleEntity.class);
	 * ================================================================================
	 * 
	 * 
	 * 
	 * 3) Domain 매핑 클래스 사용
	 * - 같은 성격의 DTO와 Entity의 Convert 메소드를 한번에 관리 
	 * ================================================================================
	 * ■ Sample Source
	 * public class SampleMapper {
	 * 
	 *     public SampleDTO toDto(SampleEntity sampleEntity) {
	 *         SampleDTO sampleDto = new SampleDTO();
	 *         sampleDto.setCol1(sampleEntity.getCol1());
	 *         sampleDto.setCol2(sampleEntity.getCol2());
	 *         
	 *         return sampleDto;
	 *     }
	 *
	 *     public SampleEntity toEntity(SampleDTO sampleDto) {
	 *         return SampleEntity.builder().sampleDto(sampleDto).build();
	 *     }
	 * }
	 * 
	 * @Entity
	 * @NoArgsConstructor(access = AccessLevel.PROTECTED)
	 * public class SampleEntity {
	 *     
	 *     @Column
	 *     private String col1;

	 *     @Column
	 *     private String col2;
	 *     
	 *     @Builder
	 *     public SampleEntity(SampleDTO sampleDto) {
	 *     	   this.col1 = sampleDto.getCol1();
	 *     	   this.col2 = sampleDto.getCol2();
	 *     }
	 * }
	 * ================================================================================
	 */	
}
