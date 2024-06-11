package ArrayPractice;


public class Q4Test {
    public static void main(String[] args) {
        Q4[] dogArray = new Q4[5];
        dogArray[0] = new Q4("개1", "시");
        dogArray[1] = new Q4("개2", "고");
        dogArray[2] = new Q4("개3", "르");
        dogArray[3] = new Q4("개4", "잡");
        dogArray[4] = new Q4("개5", "종");

        for(int i =0; i<dogArray.length; i++){
            System.out.println(dogArray[i].showDogInfo());
        }

    }
}
