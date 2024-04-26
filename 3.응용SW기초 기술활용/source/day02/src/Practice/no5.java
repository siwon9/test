package Practice;

public class no5 {
    public static void main(String[] args) {
        for(int i=2; i<=9; i++) {

            System.out.println(i +"단 ==========");
            for(int j=i; j<=9; j++) {
               // if(i<=j) {
               //     continue;
               // }
                System.out.printf("%d X %d = %d%n", i,j,i*j);
            }
        }
    }
}
