package Coffee_pracitce2;

public class TestCoffee {
    public static void main(String[] args) {
        Person Kim = new Person("Kim",10000);
        Person Lee = new Person("Lee", 10000);
        Coffee starCoffee = new StarCoffee();
        Coffee beanCoffee = new BeanCoffee();

        Kim.getCoffee(beanCoffee, "라떼");
        Lee.getCoffee(starCoffee, "아메리카노");
    }
}
