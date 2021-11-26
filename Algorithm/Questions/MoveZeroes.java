package Algorithm.Questions;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes01(int[] nums) {
        int zeros=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                zeros++;
            }else{
                int temp = nums[i];
                nums[i] = nums[i-zeros];
                nums[i-zeros]=temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes02(int[] nums) {
        int zero=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                int temp = nums[i];
                nums[i]=nums[zero];
                nums[zero++]=temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }



    public static void main(String[] args) {
        int[] nums= {0,1,2,0,3,12};
        new MoveZeroes().moveZeroes02(nums);
    }
}
