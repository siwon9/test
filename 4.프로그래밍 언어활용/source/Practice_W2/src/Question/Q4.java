package Question;

public class Q4 {
    public static void main(String[] args) {
        int price = 150000;
        int result = solution(price);
        System.out.printf("총 결재금액은 %d원 입니다.", result);
}
    public static int solution(int price) {
        if (price >= 100000 && price < 300000) {
            price -= price * 0.05;
        } else if (price >= 300000 && price < 500000) {
            price -= price * 0.1;
        } else if (price >= 500000) {
            price -= price * 0.2;
        }
        return price;
    }
}
