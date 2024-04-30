package Coffee_practice3;

public class BeanCoffee implements Coffee{
    int totalProfit;
    int Price;

    @Override
    public String brewing(String name) {
        totalProfit += getPrice(name);
        return String.format("%s 에서 %s 를 %d원으로 구매했습니다." +
                "콩카페의 수익은 %d원 입니다.%n", "콩카페", name, Price, totalProfit);
    }

    @Override
    public int getPrice(String name) {
        Price = name.equals("라떼") ? Menu.BEANLATTE : Menu.BEANAMERICANO;
        return Price;
    }
}
