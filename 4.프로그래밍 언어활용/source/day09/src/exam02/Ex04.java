package exam02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input a sentence:");
        String str = sc.nextLine();

        // 뒤에 ,Pattern.CASE_INSENSITIVE 도 대소문자 임
        Pattern p1 = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE); // [a-z]는 소문자만임 , [a-zA-Z]는 대소문자 포함임
        Matcher m1 = p1.matcher(str);
        if(!m1.find()) {
            System.out.println("Alphabet is not included.");
        }
    }
}
