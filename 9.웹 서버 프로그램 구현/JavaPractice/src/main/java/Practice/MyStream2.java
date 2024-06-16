package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyStream2 {
    public static void main(String[] args) {

        List<String> sList = new ArrayList<>();
        sList.add("A");
        sList.add("B");
        sList.add("C");

        Stream<String> stream = sList.stream();
        stream.forEach(s-> System.out.println(s + " " ));
        System.out.println();

        sList.stream().sorted().forEach(e-> System.out.println(e));
    }
}
