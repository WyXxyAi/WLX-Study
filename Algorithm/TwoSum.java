package Algorithm;

import java.util.*;

public class TwoSum {
    /**
     * @param nums    数组
     * @param target   两数之和
     * @return  两数之和的下标
     * @author wlx
     */
    public int[] twosum(int[] nums,int target){
        Map map = new HashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                res = new int[]{ (int) map.get(target-nums[i]),i};
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,8,4,9};
        nums = new TwoSum().twosum(nums,6);
        System.out.println(Arrays.toString(nums));
    }
}
