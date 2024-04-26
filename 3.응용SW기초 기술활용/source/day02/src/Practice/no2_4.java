package Practice;

public class no2_4 {
    public static void main(String[] args) {
        for (int i=1; i<=40; i++){
            int roomNo = i % 10 ;
            System.out.printf("학생%d, 방번호%d%n",i,roomNo);
        }
    }
}
