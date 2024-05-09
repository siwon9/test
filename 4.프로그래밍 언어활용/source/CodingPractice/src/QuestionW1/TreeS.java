package QuestionW1;

import java.util.stream.IntStream;

public class TreeS {
    public static void main(String[] args) {
        tree(4); // 삼각형 높이 설정
    }

    public static void tree(int height) {
        IntStream.range(0, height)
                .forEach(i -> {
                    IntStream.range(0, height -i - 1).forEach(j -> System.out.print(" "));
                    IntStream.range(0, 2 * i + 1).forEach(j -> System.out.print("*"));
                    System.out.println();
                });


    }
}
