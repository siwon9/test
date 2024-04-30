package Coffee_pracitce2;

public class StarCoffee implements Coffee {
    int totalProfit;
    int Price;

    @Override
    public String brewing(String name) {
        totalProfit = getPrice(name);
        return String.format("%s 에서 %s를 %d로 구매했습니다. " +
                "콩카페의 총 이익은 %d%n원이며", "별다방", name, Price, totalProfit);
    }

    @Override
    public int getPrice(String name) {
        Price = name.equals("라떼") ? Menu.STARLATTE : Menu.STARAMERICANO;
        return Price;
    }
}
