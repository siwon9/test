package exam01;

import java.sql.SQLOutput;

public class Ex03 {
    public static void main(String[] args) {
        Student s1 = new Student( 1000, "naname", "JAVA");
        s1.study(); // 함수가 실행되려면 우선 객체가 먼저 생성되어야 한다.

        Student s2 = new Student( 1001, "naname1", "JAVA1");
        s2.study();
        //System.out.println(System.identityHashCode(s1));
    }
}
