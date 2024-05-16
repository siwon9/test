package Question;

import java.util.Arrays;
// 배열 길이가 5인 정수형 배열을 선언하고 1~10 중 짝수만을 배열에 저장한 후 그 합을 출력하세요
public class Q3_3 {
    public static void main(String[] args) {
        int[] array = new int[5];
        int index = 0; // 배열순서
        int sum = 0; // 짝수 합

        for (int i=1; i<=10; i++ ) {
            if(i%2==0) {
                array[index] += i;
                sum += i;
                index++;
            }
        }
        System.out.println(sum);
    }
}
