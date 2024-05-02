package Coffee;

import java.util.HashMap;

public class Starbucks extends ACoffeeShop{
    public static HashMap<String, Integer>menus;

    static{
        menus = new HashMap<>();
        menus.put("아메리카노", 4000);
        menus.put("라떼", 4500);
    }

    public Starbucks() {
        super("스타벅스",menus);
    }
}
