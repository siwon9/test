package MyCollection1;

import java.util.HashSet;
import java.util.Set;

public class ex03 {
    public static void main(String[] args) {
        Object[] arr = {"1", Integer.valueOf(1), "2","2","2","3","3"};
        Set set = new HashSet();

        for (int i =0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        System.out.println(set);
    }
}
