package Practice6_1;

public class Taxi {
    private int money;
    private int totalMoney;

    public void take (int money) {
        this.money = money;
        totalMoney += money;
    }

    public void showInfo() {
        System.out.println("택시");
    }
}
