package com.study.basketball.tt.ad;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.basketball.ad.repository.AdUserRepository;

class AdUserRepositoryTest {

	@Autowired
	private AdUserRepository adUserRepository;
	
	@Test
	void test() {
		adUserRepository.count();
		fail("Not yet implemented");
	}

}
