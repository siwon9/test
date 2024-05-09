package QuestionW1;


import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        int total = 8;
        IntStream.range(0, total).forEach(i -> {
            System.out.print(" ".repeat(total - i - 1));
            System.out.println("*".repeat(i*2 + 1)); // 줄개행
        });
    }
}
