package exam01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex12 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("name3","name1","name2","name4","name5");
        //Collections.sort(names); // 기본 정렬 기준 (Natural Order - java.lang.Comparable,
        // int compareTo(...)
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);
    }
}
