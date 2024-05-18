package Question3;

import java.io.FileOutputStream;
import java.io.IOException;

public class Q1 {
    public static void main(String[] args) {
        try{
            FileOutputStream java = new FileOutputStream("a.text");
            java.write("지금까지 자바 정말 재미있게 공부했어요^^".getBytes()); // getBytes 찾아봄

            java.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
