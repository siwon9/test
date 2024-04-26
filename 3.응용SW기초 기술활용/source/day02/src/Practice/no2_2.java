package Practice;

public class no2_2 {
    public static void main(String[] args) {
        for(int i=1; i<=40; i++) {
            int roomNo = i % 10;
            System.out.printf("학생%d 는 %d번방입니다.%n", i, roomNo );
        }
    }
}
