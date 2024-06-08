package exam01;

import org.junit.jupiter.api.*;

@Tag("exercise")
public class Ex02Test {

    @BeforeAll
    static void beforeAll() { // 모든게 시작하기 전에 한번
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() { // 모든게 다 끝나고 한번
        System.out.println("After All");
    }

    @BeforeEach
    void beforeEach() { //처음에 각각 한번씩
        System.out.println("Beafore Each");
    }

    @AfterEach
    void afterEach() { // 나중에 각각 한번씩
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
