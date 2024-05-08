package exam03;

public class Board3 {
    private static Board3 tom;

    private Board3() {};

    public static Board3 tom() {
        if(tom == null) {
            tom = new Board3();
        }
        return tom;
    }
}
