package MyLamda;

import java.util.function.BiFunction;

public class MyBiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> bif = (a,b) -> a + b;
        int result = bif.apply(4,5);
        System.out.println(result);
    }
}
