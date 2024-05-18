package MyLamda;

import java.util.function.BiConsumer;
public class MyBiConsumer {
    public static void main(String[] args) {
        BiConsumer<String, Integer> bic = (a, b) -> System.out.println(a + ":" + b);
        bic.accept("hello", 5);
    }
}