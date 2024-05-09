package QuestionW1;

import java.util.stream.IntStream;

public class Diamond {
    public static void main(String[] args) {
        printDiamond(5); // 마름모의 높이 설정
    }

    public static void printDiamond(int height) {
        // 위로 올라가는 삼각형 출력
        IntStream.range(0, height)
                .forEach(i -> {
                    System.out.println(" ".repeat(height - i - 1) + "*".repeat(2 * i + 1));
                });

        // 아래로 내려가는 삼각형 출력
        IntStream.range(0, height - 1)
                .forEach(i -> {
                    System.out.println(" ".repeat(i + 1) + "*".repeat(2 * (height - i - 1) - 1));
                });
    }
}
