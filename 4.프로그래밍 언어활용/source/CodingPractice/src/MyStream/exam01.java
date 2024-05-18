package MyStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class exam01 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> ints = list.stream();

        Stream<String> str = Stream.of("a","b","c","d","e");
        str.forEach(System.out::print);


        System.out.println();
        ints.forEach(i -> System.out.println(i));
    }
}
