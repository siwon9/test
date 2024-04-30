package coffee_P;

public class BeanCoffee {
    int money;

    public String brewing(int money) {
        this.money = money;
        if (money == CoffeeMenu.BEANLATTEE) {
            return "콩다방 라떼를 구입했습니다";
        } else {return null;}
    }
}