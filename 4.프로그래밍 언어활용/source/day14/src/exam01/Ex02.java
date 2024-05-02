package exam01;

import org.w3c.dom.ls.LSOutput;

import java.util.function.BiFunction;

public class Ex02 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer>calc = (a,b)->a+b;
        int result = calc.apply(10,20);
        System.out.println(result);
        /**
         * 1. 연산을 위해서 Integer --> int(언박싱), 반환값 Integer로 변환(오토박싱), int result로 변환 -->
         *      (언박싱) --> 성능저하, 연산은 기본형으로 하는게 좋다.
         * 2. 자료형 반복
         */
    }
}
