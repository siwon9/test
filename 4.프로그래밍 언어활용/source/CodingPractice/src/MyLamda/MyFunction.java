package MyLamda;

import java.util.function.Function;

public class MyFunction {
    public static void main(String[] args) {
        Function<Integer, String> fun = i -> "Number"+i;

        String result = fun.apply(5);
        System.out.println(result);
    }
}
