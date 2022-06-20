package com.study.basketball.cm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @title	: Spring Security 설정 클래스
 * @author	: 김모세
 * @create	: 2022.06.06
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class CmSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
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
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**")
					  .antMatchers("/js/**")
					  .antMatchers("/images/**");
	}
}
