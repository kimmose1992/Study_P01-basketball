package com.study.basketball.cm.security;

import org.springframework.context.annotation.Configuration;

/**
 * @title	: Spring Security 설정 클래스
 * @author	: 김모세
 * @create	: 2022.06.06
 */
@Configuration
public class CmSecurityConfig_20220705 {
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
	
	/**
	 * [기존] WebSecurityConfigurerAdapter 상속 구현
	 * - Spring Security 5.7 부터 deprecated
	 * [변경] SecurityFilterChain을 Bean으로 등록
	 * - but, 2022.06 기준 스프링 Doc에서 기존 방법 사용하는것 권장 
	 */
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			/** Intercept URL */
//			.authorizeRequests()
//			.antMatchers("/", "/cm/**", "/ur/**").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			
//			/** Login */
//			.formLogin()
//			.loginPage("/ur/VWUR0001")
//			.usernameParameter("userId")
//			.passwordParameter("userPw")
//			.loginProcessingUrl("/signIn")
//			.successHandler(new CmLoginSuccessHandler())
//			.failureHandler(new CmLoginFailureHandler())
//			.permitAll()
//			.and()
//			
//			/** Logout */
//			.logout()
//			.invalidateHttpSession(true)
//			.and()
//			//.exceptionHandling()
//			//.accessDeniedHandler()
//		
//			/** Header */
//			.headers()
//			.cacheControl().disable()
//			.frameOptions().sameOrigin();
//		
//		return http.build();
//	}

}
