package exam03;

import java.util.function.BiFunction;

public class Ex01 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> calc = (a,b) -> a+b;
        // 오토박싱과 언박싱을 반복하게되서 성능이 느려진다.
        //
        int result = calc.apply(10,20);
        System.out.println(result);
    }
}
