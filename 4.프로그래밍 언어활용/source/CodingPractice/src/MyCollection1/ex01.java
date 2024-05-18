package MyCollection1;

import java.util.Arrays;

public class ex01 {
    public static void main(String[] args) {
        int[] arr = {1,9,2,8,5};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int idx = Arrays.binarySearch(arr,1);
        System.out.println(idx);
    }
}
