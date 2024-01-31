package com.sb.sampleapi.example;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestExample {

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {

    }

    @Test
    void succedingTest() {
    }

    @Test
    void failingTest() {
        fail("테스트 실패");
    }

    @Test
    public void addTest() {
        assertEquals(210, Integer.sum(10, 200));
    }
}
