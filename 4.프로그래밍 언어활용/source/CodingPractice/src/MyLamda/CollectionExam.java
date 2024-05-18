package MyLamda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionExam {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++) {
            list.add(i);
        }

        list.forEach(i -> System.out.println(i + ","));
        System.out.println();

        list.removeIf(x -> x%2 == 0 || x%3 ==0);
        System.out.println(list);

        list.replaceAll(x->x*10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");

        map.forEach((a,b)-> System.out.println(a + ":" + b));
    }
}
