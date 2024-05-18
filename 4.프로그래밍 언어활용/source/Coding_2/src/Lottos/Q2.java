package Lottos;


import java.util.stream.IntStream;

// Q2. 1~46의 랜덤한 정수 6개를 중복없이 출력해보세요.
public class Q2 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,6).forEach(i ->
                System.out.println((int)(Math.random() * 47)));
    }
}
