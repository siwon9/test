package MyLamda;

import java.util.function.Predicate;

public class MyPredicate {
    public static void main(String[] args) {
        Predicate<String> pre = s -> s.length() > 5;

        boolean result = pre.test("hello,world");
        System.out.println(result);
    }
}
