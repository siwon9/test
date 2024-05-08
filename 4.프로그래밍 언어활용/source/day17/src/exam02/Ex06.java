package exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ex06 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate today2 = today.plus(150, ChronoUnit.DAYS);
        LocalDate today3 = today.minus(150, ChronoUnit.DAYS);

        System.out.println(today);
        System.out.println(today2);
        System.out.println(today3);
    }
}



