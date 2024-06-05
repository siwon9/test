package exam01;

import member.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Ex01Test {
    @Test
    void test1() {
        Calculator cal = new Calculator();
        int num1 = 10, num2 = 20;
        int result = cal.add(num1,num2);
        assertEquals(30, result);
    }

    @Test
    void test2() {
        Calculator
    }
}



