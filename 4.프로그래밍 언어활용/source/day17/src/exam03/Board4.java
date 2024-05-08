package exam03;

public class Board4 {
    private static Board4 japan;

    private Board4 () {};

    public static Board4 japan() {
        if(japan == null) {
            japan = new Board4 ();
        }
        return japan;
    }
}
