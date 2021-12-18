package Algorithm;

import java.util.Arrays;

public class ContainsDuplicate {
    //思路一:先排序，再两两比较
    public boolean containsDuplicate01(int[] nums){
        if (nums.length<2){
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }

    //思路二:模仿冒泡排序，不排序只比较，相等就要退出。
    public boolean containsDuplicate02(int[] nums){
        if (nums.length<2){
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length-i; j++) {
                if (nums[i]==nums[i+j]){
                    return true;
                }
            }
        }
        return false;
    }

    //思路三:二分查找
    public boolean containsDuplicate03(int[] nums){

        return false;
    }
    public static void main(String[] args) {
        int[] numsF = {7,1,5,3,6,4};
        int[] numsT = {7,1,5,3,1,4};
        System.out.println(new ContainsDuplicate().containsDuplicate02(numsT));
    }
}
