package Practice;

public class P2_2 {
    static long orderNo = 201803120001L;
    static String userId = "abc123";
    static String date = "2018년 3월 12일";
    static String userNm = "홍길순";
    static String productNo = "PD0345-12";
    static String address = "서울시 영등포구 여의도동 20번지";


    public static void main(String[] args) {
        System.out.printf("주문번호 : %d%n" +
                "주문자아이디 : %s%n" +
                "주문날짜 : %s%n" +
                "주문자이름 : %s%n" +
                "주문상품번호 : %s%n" +
                "배송 주소 : %s%n", orderNo, userId, date, userNm, productNo, address);
    }
}
