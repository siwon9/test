package MyLamda;

import java.util.function.ObjIntConsumer;

public class MyOIC {
    public static void main(String[] args) {
        ObjIntConsumer<String> oic = (a,b) -> System.out.println(a+b);
        oic.accept("hello", 5);
    }
}
