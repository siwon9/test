package Coffee_practice3;

public class StarCoffee implements Coffee{
    int totalProfit;
    int Price;

    @Override
    public String brewing(String name) {
        totalProfit += getPrice(name);
        return String.format("%s 에서 %s를 %d로 구매했습니다." +
                "별다방의 수입은 %d입니다.%n", "별다방", name, Price, totalProfit);
    }
    @Override
    public int getPrice(String name) {
        Price = name.equals("라떼") ? Menu.STARLATEE : Menu.STARLATEE;
        return Price;
    }
}
