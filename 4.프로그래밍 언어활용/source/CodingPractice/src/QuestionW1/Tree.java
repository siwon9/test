package QuestionW1;

public class Tree {
    public static void main(String[] args) {
        int n = 4;
        for(int i=0; i<n;i++){
            for(int k = 0; k<n-i; k++){
                System.out.print(" ");
            }
            for(int j = n; j>0;j--){
                System.out.print("*");
            }
            n+=2;
            System.out.println();
        }

    }
}
