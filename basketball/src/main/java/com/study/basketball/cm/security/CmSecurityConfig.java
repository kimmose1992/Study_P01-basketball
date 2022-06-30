package com.study.basketball.cm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @title	: Spring Security 설정 클래스
 * @author	: 김모세
 * @create	: 2022.06.06
 */
@Configuration
public class CmSecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	/**
	 * [기존] WebSecurityConfigurerAdapter 상속 구현
	 *  - Spring Security 5.7 부터 deprecated
	 * [변경] SecurityFilterChain을 Bean으로 등록
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			/** Intercept URL */
			.authorizeRequests()
			.antMatchers("/", "/cm/**", "/ur/**").permitAll()
			.anyRequest().authenticated()
			.and()
			
			/** Login */
			.formLogin()
			.loginPage("/ur/VWUR0001")
			.usernameParameter("userId")
			.passwordParameter("userPw")
			.loginProcessingUrl("/signIn")
			.permitAll()
			.and()
			
			/** Logout */
			.logout()
			.invalidateHttpSession(true)
			.and()
			//.exceptionHandling()
			//.accessDeniedHandler()
		
			/** Header */
			.headers()
			.cacheControl().disable()
			.frameOptions().sameOrigin();
		
		return http.build();
	}
}
