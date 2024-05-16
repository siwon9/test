package exam01;

import java.io.File;
import java.io.IOException;

public class Ex06 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File tmpFile = File.createTempFile("tmp",".log", new File("home/fstudy"));

        // tmpFile.delete(); // 바로 삭제
        tmpFile.deleteOnExit(); // 어플 종료되면 삭제

        Thread.sleep(5000);

        System.out.println("종료!");
    }
}
