package com.study.basketball.tt.cm;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @title	: Spring Security PasswordEncoder 테스트 클래스
 * @author	: 김모세
 * @create	: 2022.07.07
 */
class PasswordEncoderTest {

	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}	
	
	@Test
	void test() {
		String password = "1234";
		String passwordEncrypt = passwordEncoder().encode(password);
		//passwordEncrypt = "{bcrypt}$2a$10$7i3ds5WZpXN0KvbeAw/iTOMaVM8dexE7GG/ ";
		
		System.out.println("===================================");
		System.out.println("## password :: " + password);
		System.out.println("## passwordEncrypt :: " + passwordEncrypt);
		System.out.println("## matches :: " + passwordEncoder().matches(password, passwordEncrypt));
		System.out.println("## passwordEncrypt :: " + passwordEncrypt.trim());
		System.out.println("## matches :: " + passwordEncoder().matches(password, passwordEncrypt));
		System.out.println("===================================");
	}

}
