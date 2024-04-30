package Coffee_practice4;

public class TestCoffee {
    public static void main(String[] args) {
        Person Kim = new Person("kim", 10000);
        Person Lee = new Person("lee", 10000);

        Coffee starCoffee = new StarCoffee();
        Coffee beanCoffee = new BeanCoffee();

        Kim.getCoffee(beanCoffee, "라떼");
        Kim.getCoffee(starCoffee, "아메리카노");
    }
}
