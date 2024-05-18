package Question3;


import java.util.HashMap;

class Car {
    String name;
    public Car() {}
    public Car(String name) {
        this.name = name;
    }
}

public class Q3 {
    public static void main(String[] args) {
        HashMap factory = new HashMap();
        factory.put("sonata1", "연수차");
        factory.put("sonata2", "연수차");
        factory.put("avante1", "승연차");
        factory.put("avante2", "승연차");

        Object sonata1 = factory.get("sonata1");
        Object sonata2 = factory.get("sonata2");
        Object avante1 = factory.get("avante1");
        Object avante2 = factory.get("avante2");

        System.out.println(sonata1.equals(sonata2));
        System.out.println(avante1.equals(avante2));
        System.out.println(sonata1.equals(avante1));
    }
}