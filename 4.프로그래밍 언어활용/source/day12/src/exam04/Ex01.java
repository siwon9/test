package exam04;

public class Ex01 {
    public static void main(String[] args) {
        StarBucks starBucks = new StarBucks();
        CoffeeBean coffeeBean = new CoffeeBean();

        Person kim = new Person("kim", 10000);
        Person lee = new Person("lee", 15000);
        try {
            kim.setMenu("Americano");
            lee.setMenu("Latte");
            starBucks.enter(kim).order().exit();
            coffeeBean.enter(lee).order().exit();

            System.out.println(kim);
            System.out.println(lee);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("커피숍별 매출 요약");
        CoffeeShop.showSalesSummary(starBucks);
        CoffeeShop.showSalesSummary(coffeeBean);
    }
}
