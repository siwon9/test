package exam01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex10 {
    public static void main(String[] args) {
        List<String> names =  Arrays.asList("name1", "name2", "name3", "name4", "name5");

        Collections.shuffle(names);
        System.out.println(names);

        String max = Collections.max(names);
        System.out.println(max);

        String min = Collections.min(names);
        System.out.println(min);
    }
}
