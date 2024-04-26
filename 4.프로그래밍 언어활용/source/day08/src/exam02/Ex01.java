package exam02;

public class Ex01 {
    public static void main(String[] args) {
        String s1 = new String("ABC"); // 힙영역 - 문자열 상수 풀
        String s2 = new String("ABC"); // 힙영역 - 문자열 상수 풀
        System.out.printf("s1 == s2 : %s%n", s1 == s2);
        System.out.printf("s1 주소 : %d%n", System.identityHashCode(s1));
        System.out.printf("s2 주소 : %d%n", System.identityHashCode(s2));
    }
}
