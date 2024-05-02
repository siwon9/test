package exam01;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[][] nums1 = {{10,20,30}, {40,50,60}};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.deepToString(nums1));
        // 여기서 그냥 toString 만하게되면 두 배열의 주소값만 나오지만
        // deepToString을 해야 그 안에있는 요소들을 보여주게 됨
    }
}
