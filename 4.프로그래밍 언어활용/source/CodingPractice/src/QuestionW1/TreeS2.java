package QuestionW1;

import java.util.stream.IntStream;

public class TreeS2 {
    public static void main(String[] args) {
        tree(4); // 삼각형 높이 설정
    }

    public static void tree(int height) {
        IntStream.range(0, height)
                .forEach(i -> {
                    System.out.println(" ".repeat(height - i - 1) + "*".repeat(2 * i + 1));
                });
    }
}
