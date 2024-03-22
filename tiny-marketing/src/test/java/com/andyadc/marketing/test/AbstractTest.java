package com.andyadc.marketing.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTest {

    @BeforeAll
    protected static void beforeAll() {
        System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
    }

    @AfterAll
    protected static void afterAll() {
        System.out.println("------------------------------");
    }

    @BeforeEach
    protected void beforeEach() {
        System.out.println("------------------------------");
    }

    @AfterEach
    protected void afterEach() {
        System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
    }
}
