package exam02;

public class Ex03 {
    public static void main(String[] args) {
        //int[] nums = new int [] {10,20,30,40};
        int[] nums = {10,20,30,40,50,60,70};

        // int[] nums;
        //nums = new int[] {10,20,30,40};

        // nums = {10,20,30,40}; // 오류발생
        System.out.println("공간의 갯수 : " + nums.length);
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
