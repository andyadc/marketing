package com.andyadc.marketing.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class TestBase {

	@BeforeAll
	static void beforeAll() {
		System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("------------------------------");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("------------------------------");
	}

	@AfterEach
	void afterEach() {
		System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
	}

}
