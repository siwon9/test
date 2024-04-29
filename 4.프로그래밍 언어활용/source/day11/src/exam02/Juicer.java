package exam02;

import java.util.ArrayList;

public class Juicer {
    public static void make(FruitBox<? extends Fruit> box) { // ?는 Fruit, Apple, Grape 만 가능
        ArrayList<?> fruits = box.getItems();
        System.out.println(fruits);
    }

    public static <T extends Fruit> void make3(FruitBox<T> box) {

    }

    public static void make2(FruitBox<? super Apple> box) { // Apple, Fruit, Object
        ArrayList<?> fruits = box.getItems();
        System.out.println(fruits);
    }

}
