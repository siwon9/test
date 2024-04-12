package exam01;

public class Ex09 {
    public static void main(String[] args) {
        long num1 = 100_000_000_000_000_000L;
        double num2 = num1; // 정수  ->  실수 : 자동 형변환(묵시적 형변환)
        float num3 = num1; // 실수는 범위가 작아도 모든 정수를 포괄하기 때문에 담을 수 있음

        double num4 = 0.0;
        for(int i =0; i < 1000; i++) {
            num4 += 0.1;
        }
        System.out.println(num4);
    }
}
