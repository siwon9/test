package MyLamda;

import java.util.function.IntFunction;

public class MyIntFunction {
    public static void main(String[] args) {
        IntFunction<String> itf = i -> "she is" + i;

        String result = itf.apply(10);
        System.out.println(result);
    }
}
