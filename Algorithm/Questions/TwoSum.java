package Algorithm.Questions;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return res = new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = new TwoSum().twoSum(nums,target);
        System.out.println(Arrays.toString(res));
    }
}
