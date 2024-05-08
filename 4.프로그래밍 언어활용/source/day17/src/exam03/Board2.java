package exam03;

public class Board2 {
    private static Board2 siwon;

    private Board2() {}

    public static Board2 getInstance() {
        if (siwon == null) {
            siwon = new Board2();
        }
        return siwon;
    }
}
