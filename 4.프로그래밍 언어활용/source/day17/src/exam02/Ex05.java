package exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Ex05 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate lastYear = today.with(ChronoField.YEAR, 2023);

        System.out.println(today);
        System.out.println(lastYear);
    }
}
