package exam01_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("exercise")
public class Ex01T {

    @Test
    @DisplayName("siwon")
    void test1(){
        Cal cal = new Cal();
        int num1 = 10, num2 =20;
        int result = cal.add(num1,num2);
        System.out.println(result);
    }
}
