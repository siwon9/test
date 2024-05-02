package exam05;

public class Ex01 {
    public static void main(String[] args) {
        StarBucks starBucks = new StarBucks();
        CoffeeBean coffeeBean = new CoffeeBean();

        Person lee = new Person("lee",10000);
        Person kim = new Person("kim", 15000);

        kim.setMenu("Americano");
        lee.setMenu("Latte");

        try {
            starBucks.enter(lee).order().exit();
            coffeeBean.enter(kim).order().exit();

            System.out.println(lee);
            System.out.println(kim);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("커피숍별 매출액 요약");
        CoffeeShop.showSalesSummary(starBucks);
        CoffeeShop.showSalesSummary(coffeeBean);
    }
}
