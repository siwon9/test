package exam05;

import java.util.HashMap;
import java.util.Map;

public class CoffeeBean extends AbstractCoffeeShop{
    public static Map<String, Integer> menus;

    static {
        menus = new HashMap<>();
        menus.put("Americano", 5000);
        menus.put("Latte", 6000);
    }

    public CoffeeBean () {
        super("커피빈", menus);
    }

}
