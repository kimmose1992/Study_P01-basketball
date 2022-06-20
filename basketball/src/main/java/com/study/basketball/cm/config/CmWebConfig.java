package com.study.basketball.cm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.basketball.cm.handler.CmGlobalHandler;

/**
 * @title	: 공통 WebMvcConfigurer 구현 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.20
 */
@Configuration
public class CmWebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CmGlobalHandler())
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/images/**");
	}
}
