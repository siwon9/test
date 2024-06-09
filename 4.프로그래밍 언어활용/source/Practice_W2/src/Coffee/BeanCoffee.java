package Coffee;

public class BeanCoffee {
    int money;

    public String brewing(int money) {
        this.money += money;
        if(money == Menu.BEANAMERICANO) {
            return "콩다방에서 아메리카노를 구입하셨습니다.";
        } else if(money == Menu.BEANLATTE) {
            return "콩다방에서 라떼를 구입하셨습니다.";
        }else {
            return null;
        }
    }
}
