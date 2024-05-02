package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex11 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.add("name5");

        Collections.swap(names, 1,3);
        System.out.println(names);

        Collections.reverse(names);
        System.out.println(names);
        Collections.replaceAll(names,"name3", "이름3");
        System.out.println(names);
    }
}
