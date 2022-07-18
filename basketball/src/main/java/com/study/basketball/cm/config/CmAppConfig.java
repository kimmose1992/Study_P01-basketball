package com.study.basketball.cm.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title	: [공통] App 설정 클래스	  	  
 * @author	: 김모세
 * @create	: 2022.07.18
 */
@Configuration
public class CmAppConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
