package Practice;

import java.util.Arrays;

public class Last {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7};
        for (int i =0; i< num.length / 2; i++){ // 반나누는 식
            int index = num.length - i - 1; //바꿀 위치를 찾는 것

            int n = num[i]; // 치환하는 식
            num[i] = num[index];
            num[index] = n;
        }
        System.out.println(Arrays.toString(num));
    }
}
