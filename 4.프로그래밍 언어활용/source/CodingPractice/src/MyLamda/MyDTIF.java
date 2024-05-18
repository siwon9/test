package MyLamda;

import java.io.DataInputStream;
import java.util.function.DoubleToIntFunction;

public class MyDTIF {
    public static void main(String[] args) {
        DoubleToIntFunction dtif =  i -> (int)(i*2);
        int result = dtif.applyAsInt(3.5);
        System.out.println(result);
    }
}
