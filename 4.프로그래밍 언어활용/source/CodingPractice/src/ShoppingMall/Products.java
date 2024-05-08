package ShoppingMall;

import java.util.HashMap;

public class Products {
    public static HashMap<String, Integer> products;

    static {
        products = new HashMap<>();
        products.put("bag",15000);
        products.put("pants",50000);
        products.put("shirts",30000);
    }

}
