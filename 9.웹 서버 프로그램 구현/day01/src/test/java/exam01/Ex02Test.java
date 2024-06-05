package exam01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Ex02Test {

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
