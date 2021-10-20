package Algorithm.Primary;

import java.util.Arrays;

public class Solution {
    public void SoutN(int[] nums,int index){
        System.out.print("[ ");
        for (int i = 0; i < index; i++) {
            if (i==index-1){
                System.out.print(nums[i]+" ");
            }else {
                System.out.print(nums[i]+" , ");
            }
        }
        System.out.println("]");
    }

    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                nums[index]=nums[i];
                index++;
            }
        }
        this.SoutN(nums,index);
        System.out.println(index);
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,3,5,5,7,7,7};
        new Solution().removeDuplicates(nums);
    }
}
