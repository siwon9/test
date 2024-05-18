package MyStream;

import java.io.File;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class exam {
    public static void main(String[] args) {
        int[] num = {1,2,3,4};
        OptionalInt sum = Arrays.stream(num).reduce((x,y) -> x +y);

        if(sum.isPresent()) {
            System.out.println(sum.getAsInt());
        } else {
            System.out.println("no");
        }
    }
}
