package exam02;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;
import java.time.format.TextStyle;

public class Ex03 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        Month month = today.getMonth();

        Locale locale = new Locale("ko","kr");
        //String yoilStr = month.getDisplayName(TextStyle.Full, locale);
        //System.out.println(yoilStr);

        String yoilStrEng = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println(yoilStrEng);
    }
}
