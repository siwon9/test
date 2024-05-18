package MyLamda;

public class ex01 {
    public static void main(String[] args) {
        MyCalculator cal = (x,y) -> x + y;
        int result = cal.plus(2,3);

        System.out.println(result);
    }
}
