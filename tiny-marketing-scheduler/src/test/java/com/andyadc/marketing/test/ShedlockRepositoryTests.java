package com.andyadc.marketing.test;

import com.andyadc.marketing.repository.Shedlock;
import com.andyadc.marketing.repository.ShedlockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShedlockRepositoryTests {

	@Autowired
	private ShedlockRepository shedlockRepository;

	@Test
	public void test_findAll() {
		Iterable<Shedlock> shedlocks = shedlockRepository.findAll();
		shedlocks.forEach(System.out::print);
	}
}
