package Lottos;

// Q3. 1~46의 랜덤한 정수 6개를 중복없이 출력했을때의 확률을 구해보세요

import java.util.stream.IntStream;

public class Q3 {
    public static void main(String[] args) {
        double result = probability(46);
        System.out.println(result);
    }

    public static double probability(int a) {
        return (double) factorial(a) / factorial(a-6);
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
