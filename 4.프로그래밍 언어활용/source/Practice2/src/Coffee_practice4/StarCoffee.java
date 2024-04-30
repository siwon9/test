package Coffee_practice4;

public class StarCoffee implements Coffee{
    int totalPrice;
    int Price;

    @Override
    public String brewing(String name) {
        totalPrice += getPrice(name);
        return String.format("%s 에서 %s를 %d원으로 구매했습니다." +
                "별다방의 수익은 %d원 입니다.%n", "별다방", name, Price, totalPrice);
    }

    @Override
    public int getPrice(String name) {
        Price = name.equals("라뗴")? Menu.STARAMERICANO : Menu.STARLATTE;
        return Price;
    }
}
