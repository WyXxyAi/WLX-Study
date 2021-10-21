package Algorithm.Primary;

import java.util.Arrays;

public class Rotate {
    public void rotate1(int[] nums,int k) {
        for (int i = 0; i < nums.length-k; i++) {
            int temp = nums[i+k];
            nums[i+k]=nums[i];
            nums[i]=temp;
        }
        System.out.println(Arrays.toString(nums));
    }

    public void rotate2(int[] nums,int k) {
        int[] head = Arrays.copyOfRange(nums,0,nums.length-k);
        int[] foot = Arrays.copyOfRange(nums,nums.length-k,nums.length);
        int[] res = new int[nums.length];
        System.arraycopy(foot, 0, res, 0, foot.length);
        System.arraycopy(head, 0, res, foot.length, head.length);
        System.out.println(Arrays.toString(res));
    }
    public static void main(String[] args) {
        int[] nums = {4,7,8,9,1,6,3,5};
        new Rotate().rotate2(nums,3);
    }

}