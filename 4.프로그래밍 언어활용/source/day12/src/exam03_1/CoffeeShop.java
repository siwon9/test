package exam03_1;

public interface CoffeeShop {
    Coffeeshop enter(Person person);
    Coffeeshop order();
    void exit();

    int getTotalSalePrice();
    String getName;
}
