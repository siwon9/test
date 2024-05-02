package exam04;

import java.util.HashMap;
import java.util.Map;

public class CoffeeBean extends AbstractCoffeeShop{
    private static Map<String, Integer> menus;

    static {
        menus = new HashMap<>();
        menus.put("Americano", 3500);
        menus.put("Latte", 4000);
    }

    public CoffeeBean() {
        super("커피빈",menus);
    }
}
