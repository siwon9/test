package exam02;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // System.out.print("input including numbers:");
        System.out.print("input only numbers:");
        String str = sc.nextLine();

        //Pattern p1 = Pattern.compile("[0-9]"); // 숫자 포함
        //Pattern p1 = Pattern.compile("\\d"); // \\두개를 해야지 \가 한개 제거되고 한개로 인식이됨(아래랑 같음 = [^0-9])
        //Pattern p1 = Pattern.compile("[^0-9]");
        Pattern p1 = Pattern.compile("\\D"); // 숫자가 아닌 패턴을 의미한다.
        Matcher m1 = p1.matcher(str);
        if (m1.find()) {
            System.out.println("input ontly numbers ");
        }

        /*
        if(!m1.find()) {
            System.out.println("Please input including numbers");
        }

         */
    }
}
