package Algorithm.Primary;

import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums){
        if (nums.length>=2){

        }else {
            return nums[0];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums ={4,1,2,2,4,1,3};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}
