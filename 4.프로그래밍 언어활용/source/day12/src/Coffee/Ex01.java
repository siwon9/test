package Coffee;

public class Ex01 {
    public static void main(String[] args) {
        Starbucks starBucks = new Starbucks();
        CoffeeBean coffeeBean = new CoffeeBean();

        Person lee = new Person("lee", 10000);
        Person kim = new Person("kim", 10000);

        kim.setMenu("아메리카노");
        lee.setMenu("라떼");

        try {
            starBucks.enter(kim).order().exit();
            coffeeBean.enter(lee).order().exit();

            System.out.println(lee);
            System.out.println(kim);
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("커피숍별 매출액 요약");
        CoffeeShop.showSalesSummary(starBucks);
        CoffeeShop.showSalesSummary(coffeeBean);
    }
}
