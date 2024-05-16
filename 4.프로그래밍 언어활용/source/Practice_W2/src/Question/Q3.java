package Question;

// 정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때,
// array에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성해보세요.

public class Q3 {
    public static void main(String[] args) {
        int[] array = {1,1,2,2,2,2,4,4};
        int n = 2;
        int result = solution(array, n);
        System.out.println(result);
    }

    public static int solution(int[] array, int n) {
        int count = 0;
        for(int i : array) {
            if(i==n) {
                count++;
            }
        }
        return count;
    }
}
