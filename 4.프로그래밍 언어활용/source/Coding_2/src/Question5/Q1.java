package Question5;

import java.util.Arrays;

//Q1. 머쓱이는 행운의 숫자 7을 가장 좋아합니다. 정수 배열 array가 매개변수로 주어질 때,
// 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.
public class Q1 {
    public static void main(String[] args) {

                int[] array = {7, 77, 17};
                int num = 7;
                String numStr = String.valueOf(num);

                long count = Arrays.stream(array)
                        .mapToObj(String::valueOf)
                        .mapToLong(s -> s.chars().filter(ch -> ch == numStr.charAt(0)).count())
                        .sum();

                System.out.println(count);
            }
        }
