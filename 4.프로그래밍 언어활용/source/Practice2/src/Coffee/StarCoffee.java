package Coffee;

public class StarCoffee {
        int money;

        public String brewing(int money) {
            this.money = money;
            if (money == CoffeeMenu.STARAMERICANO) {
                return "별다방 아메리카노를 구입했습니다";
            } else {return null;}
        }
}

