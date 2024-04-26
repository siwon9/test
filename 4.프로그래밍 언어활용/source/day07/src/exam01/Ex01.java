package exam01;

import java.sql.SQLOutput;

public class Ex01 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Calculator cal = outer.method(30); // 여기에 정리가 되있어서 사용할 수 있는거임
        int result = cal.add(10,20);

        System.out.println(result);
    }
}
