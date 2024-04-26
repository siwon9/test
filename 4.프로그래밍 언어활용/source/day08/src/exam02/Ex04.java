package exam02;

public class Ex04 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(100);
        sb.append("ABC");
        System.out.printf("sb 주소: %d%n", System.identityHashCode(sb));
    //임시메모리를 만들고 나서 그 안에 문자열들을 append로 추가하면 주소값이 안바뀐채 계속 추가됨
        sb.append("DEF");
        System.out.printf("sb 주소: %d%n", System.identityHashCode(sb));

        sb.append("GHI");
        System.out.printf("sb 주소: %d%n", System.identityHashCode(sb));
    // 마지막에 문자열에 담을 때 담겨진 상태로 주소값이 바껴서 나옴
        String str = sb.toString();
        System.out.printf("str 주소: %d%n", System.identityHashCode(str));
        System.out.println(str);
    }
}
