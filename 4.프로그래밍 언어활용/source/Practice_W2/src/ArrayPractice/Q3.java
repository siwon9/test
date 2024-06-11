package ArrayPractice;
// 이런 문제는 별로 좋지 않은거같아요
public class Q3 {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        int total = 0;

        for(int i=0; i<arr.length; i++){
            total += arr[i];
        }

        System.out.println(total);
    }
}