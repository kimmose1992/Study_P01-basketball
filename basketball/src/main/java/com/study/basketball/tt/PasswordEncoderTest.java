package com.study.basketball.tt;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

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
