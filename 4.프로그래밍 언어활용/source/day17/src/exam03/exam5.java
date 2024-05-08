package exam03;

public class exam5 {
    private static exam5 mac;

    private exam5() {};

    public exam5 mac () {
        if(mac == null) {
            mac = new exam5();
        }
        return mac;
    }
}
