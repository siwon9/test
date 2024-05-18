package MyLamda;

import java.util.function.UnaryOperator;

public class MyUnaryOperator {
    public static void main(String[] args) {
        UnaryOperator<Integer> uop = (a) -> a + 20;
        int result = uop.apply(45);
        System.out.println(result);
    }
}
