package Coffee2;

public class BeanCoffee {
    int money;

    public String brewing(int money) {
        this.money += money;
        if(money == Menu.BEANAMERICANO) {
            return "커피빈에서 아메리카노를 구입했습니다";
        } else if (money == Menu.BEANLATTE) {
            return "커피빈에서 라뗴를 구입했습니다";
        } else {
            return null;
        }
    }
}
