package com.xh;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("---Before All---");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("---After All---");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("---Before Each---");
    }

    @AfterEach
    void afterEach() {
        System.out.println("---After Each---");
    }

    @Test
    void getAge() {
        Integer age = new UserService().getAge("101010200010101111");
        System.out.println("age: " + age);
    }

    @Test
    void getGender() {
        String gender = new UserService().getGender("101010200010101111");
//        System.out.println("gender: " + gender);
        assertEquals("男",gender,"通过");
    }
    @DisplayName("测试年龄")
    @ParameterizedTest
    @ValueSource(strings = {"101010200010101111","101010200110101111","101010200210101111"})
    void getGender2(String a) {
        String gender = new UserService().getGender(a);
        System.out.println("gender: " + gender);
    }
}
