package Question;

public class Q2 {
    public static void main(String[] args) {
        int money = 14000;

        int cal = money / 5500;
        int left = money-5500*cal;

        System.out.printf("%d원 으로는 커피를 %d잔 살 수 있고 남은돈은 %d입니다.", money, cal, left);
        }
}
