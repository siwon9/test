package Question;

public class copy {
    public int solution(int price) {
        if(price>=100000 && price<300000) {
            price -= price*0.05;
            System.out.printf("할인율은 5%, 총 결재금액은 %d입니다.",price);
        } else if(price>=300000 && price<500000) {
            price -= price*0.1;
            System.out.printf("할인율은 10%, 총 결재금액은 %d입니다.",price);
        } else if(price>=500000) {
            price -= price*0.2;
            System.out.printf("할인율은 20%, 총 결재금액은 %d입니다.",price);
        } else {
            System.out.println("할인이 없습니다.");
        }

        int answer = 0;
        return answer;}
}

