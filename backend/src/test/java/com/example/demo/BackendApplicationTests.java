package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.JpaUserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@Transactional
class BackendApplicationTests {

	
	@Autowired
	private JpaUserRepository u;
	
	
	@Test
	void asd() {
		UserEntity kk = UserEntity.builder().email("test@ac.kr").name("test").passwd("test").build();
		u.save(kk);
	}

}
