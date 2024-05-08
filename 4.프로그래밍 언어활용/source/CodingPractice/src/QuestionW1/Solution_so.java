package QuestionW1;

public class Solution_so {
    public static double solution(int num1, int num2) {
        return (double)num1 / num2 * 1000;
    }

    public static void main(String[] args) {
        int answer = (int)solution(3,2);
        System.out.println("결과는?" + answer);
    }
}
