package Practice;

public class Ex1 {
    public static void main(String[] args) {
        String tran1 = "TAXI";

        //Transportation BUS = Enum.valueOf(Transportation.class, tran1);
        //System.out.println(BUS.name());

        Transportation A = Transportation.valueOf(tran1);
        System.out.println(A);
    }
}
