package MyStream;

import java.util.Arrays;
import java.util.stream.Stream;

public class exam02 {
    public static void main(String[] args) {
        String[] ar1 = {"1","2","3","4","5"};
        String[] ar2 = {"6","7","8","9","0"};

        Stream<String> arr1 = Stream.of(ar1);
        Stream<String> arr2 = Stream.of(ar2);
        Stream<String> result = Stream.concat(arr1,arr2);

        result.forEach(System.out::print);
    }
}
