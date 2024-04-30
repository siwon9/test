package Coffee_practice3;

public class TestCoffee {
    public static void main(String[] args) {
        Person Lee = new Person("lee", 10000);
        Person Kim = new Person("kee", 10000);

        Coffee starCoffee = new StarCoffee();
        Coffee beanCoffee = new BeanCoffee();

        Kim.getCoffee(beanCoffee,"라뗴");
        Lee.getCoffee(starCoffee, "아아");

    }
}
