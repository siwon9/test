package exam01;

public class Ex03 { // 삼항조건 연산식
    public static void main(String[] args) {
        int num = 9;

        String str = num % 2 == 0 ? "짝수" : "홀수";
        System.out.println(str);
    }
}
