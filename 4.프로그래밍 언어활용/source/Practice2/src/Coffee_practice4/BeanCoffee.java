package Coffee_practice4;

public class BeanCoffee implements Coffee{
    int totalProfit;
    int Price;

    @Override
    public String brewing(String name) {
        totalProfit += getPrice(name);
        return String.format("%s 에서 %s를 %d원으로 구매하였습니다." +
                "콩다방의 수익은 %d원 입니다.%n", "콩다방", name, Price, totalProfit );
    }
    @Override
    public int getPrice(String name) {
        Price = name.equals("라떼") ? Menu.BEANLATTE : Menu.BEANAMERICANO;
        return Price;
    }
}
