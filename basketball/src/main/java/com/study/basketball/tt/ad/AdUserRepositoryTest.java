package com.study.basketball.tt.ad;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.basketball.ad.domain.entity.AdUserEntity;
import com.study.basketball.ad.repository.AdUserRepository;

class AdUserRepositoryTest {

	@Autowired
	AdUserRepository adUserRepository;
	
	@Test
	void test() {
		int count = (int) adUserRepository.count();
	}

}
