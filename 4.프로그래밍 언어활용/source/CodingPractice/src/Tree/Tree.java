package Tree;

public class Tree {
    public static void main(String[] args) {
        String str = "*";
        String blank = " ";

        for (int i = 1; i <= 8; i += 2) {
            // 공백 문자열 출력 (오른쪽 정렬)
            for (int j = 0; j < (8 - i) / 2; j++) {
                System.out.print(blank);
            }
            // '*' 출력
            for (int j = 0; j < i; j++) {
                System.out.print(str);
            }
            System.out.println(); // 줄 바꿈
        }
    }
}
