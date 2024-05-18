package Lottos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Q1. 1~46의 랜덤한 정수 6개를 출력해보세요.

public class Q1 {
        public static void main(String[] args) {
            for (int i = 0; i < 6; i++) {
                int num = (int) (Math.random() * 47);
                System.out.println(num);
            }
        }
    }