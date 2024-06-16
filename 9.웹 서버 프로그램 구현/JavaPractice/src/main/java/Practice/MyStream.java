package Practice;

import java.util.Arrays;

public class MyStream {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        for (int i =0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
        int[] arr2 = {1,2,3,4,5};
        Arrays.stream(arr2).forEach(n -> System.out.println(n));

        int[] arr3 = {1,2,3,4,5,6,7,8,9};
        Arrays.stream(arr3).filter(s -> s % 2 == 0).forEach(s -> System.out.println(s));

        int[] arr4 = {1,2,3,4,5};
        Arrays.stream(arr4).map(c -> c * c).forEach(s-> System.out.println(s));
    }
}
