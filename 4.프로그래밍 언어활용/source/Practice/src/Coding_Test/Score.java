package Coding_Test;

//시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C,
// 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

public class Score {
    public static void main(String[] args) {
        int Score = 50;

        if(Score>100) {
            System.out.println("유효한 점수가 아닙니다.");
        }
        else if(Score>=90){
            System.out.println("Score : A");
        }
        else if(Score>=80){
            System.out.println("Score : B");
        }
        else if(Score>=70){
            System.out.println("Score : C");
        }
        else if(Score>=60){
            System.out.println("Score : D");
        }
        else{
            System.out.println("Score : F");
        }
    }
}
