package exam02;

public class Ex01 {
    public static void main(String[] args) {
        try{
            int num1 = 10;
            int num2 = 0;
            int result = num1 / num2; // ArithmeticException

            String str = "ABC";
            System.out.println(str.toUpperCase()); // NullPointerException

        System.out.println(result);
    } catch (ArithmeticException e){
        e.printStackTrace();
    } catch (Exception e) { // Exception e = new NullPointer ...
            System.out.println("유입!");
            e.printStackTrace();
        }
        System.out.println("매우 중요한 실행코드...");
    }
}
