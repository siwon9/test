package exam02;

public class Ex02 {
    public static void main(String[] args) {
        int c = 10;
        Calculator cal = (x,y) -> {
            return x + y +c;
        };

        int result = cal.add(10,20);
        System.out.println(result);
    }
}
