package exam01;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Tag("exercise")
@DisplayName("테스트")
public class Ex01Test {
    @Test
    @DisplayName("테스트 1 연습")
    void test1() {
        Calculator cal = new Calculator();
        int num1 = 10, num2 = 20;
        int result = cal.add(num1,num2);
        assertEquals(30, result);
    }

    @Test
    @DisplayName("테스트 2 연습")
    @Disabled
    void test2() {
        LocalDate expected = LocalDate.now();
        LocalDate date = LocalDate.of(2024, 6, 5);

        assertEquals(expected, date); // equals and hashCode
        assertSame(expected,date);
    }

    @Test
    @DisplayName("테스트 3 연습")
    @Disabled
    void test3(){
        fail();
    }
}



