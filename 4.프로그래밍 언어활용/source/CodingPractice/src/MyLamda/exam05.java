package MyLamda;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class exam05 {
    public static void main(String[] args) {
        Stream<String> stm = Stream.of("apple","banana","citrus");

        List<String> col = stm.map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(col);
    }
}
