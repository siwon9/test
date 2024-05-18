package MyLamda;

import java.util.function.ToIntFunction;

public class MYTIF {
    public static void main(String[] args) {
        ToIntFunction<String> tif = i -> i.length();

        int result = tif.applyAsInt("Hello");
        System.out.println(result);
    }
}
