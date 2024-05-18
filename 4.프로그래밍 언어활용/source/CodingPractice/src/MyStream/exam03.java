package MyStream;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class exam03 {
    public static void main(String[] args) {
        IntStream is = IntStream.rangeClosed(1,10);
        //is.skip(3).limit(5).forEach(System.out::println);

        IntStream dis = IntStream.of(1,2,3,4,5,1,1,2,2,3);
        //dis.distinct().forEach(System.out::println);

        IntStream fil = IntStream.rangeClosed(1,10);
        fil.filter(i -> i% 2 ==0).forEach(System.out::println);

    }
}
