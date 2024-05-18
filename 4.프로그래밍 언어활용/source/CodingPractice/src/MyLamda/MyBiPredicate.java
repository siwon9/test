package MyLamda;

import java.util.function.BiPredicate;

public class MyBiPredicate {
    public static void main(String[] args) {
        BiPredicate<Integer,Integer> bip = (a,b) -> a+b > 10;
        Boolean result = bip.test(5,6);
        System.out.println(result);
    }
}
