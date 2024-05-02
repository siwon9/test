package Coffee;

import java.util.HashMap;
import java.util.Map;

public class CoffeeBean extends ACoffeeShop{
    public static Map<String, Integer> menus;

    static { // 클래스가 처음
        menus = new HashMap<>();
        menus.put("아메리카노", 5000);
        menus.put("라떼",6000);
    }

    public CoffeeBean() {
        super("커피빈", menus);
    }
}
