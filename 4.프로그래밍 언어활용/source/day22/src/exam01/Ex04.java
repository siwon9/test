package exam01;

import java.io.File;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        //File file = new File("home/test1.txt");
        //file.createNewFile();

        File dir = new File("Macintosh HD/Users/siwon/최시원/fstudy");
        File file = new File(dir, "test1.txt");

        // exists() : 파일 또는 디렉토리 존재 유무
        if (!dir.exists()) {
            dir.mkdir(); // 디렉토리 생성

            file.createNewFile();
        }
    }
}

