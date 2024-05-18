package MyLamda;

import java.util.function.BinaryOperator;

public class MyBinaryOperator {
    public static void main(String[] args) {
        BinaryOperator<Integer> biop = (a,b) -> a+b;
        int result = biop.apply(10,20);
        System.out.println(result);
    }
}
