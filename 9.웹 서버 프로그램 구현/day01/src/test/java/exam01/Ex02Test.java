package exam01;

import org.junit.jupiter.api.*;

public class Ex02Test {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Beafore Each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }

    @Test
    void test1() {
        System.out.println("테스트 1번 진행");
    }

    @Test
    void test2() {
        System.out.println("테스트 2번 진행");
    }
}
