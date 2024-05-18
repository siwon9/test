package MyLamda;

import java.util.function.Supplier;

public class MuSupplier {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "Hello, World";
        // 매개변수 없이 반환만 하는 형태
        System.out.println(sup.get());
    }
}
