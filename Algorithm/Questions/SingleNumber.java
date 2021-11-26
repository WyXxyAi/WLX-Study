package Algorithm.Questions;

import java.util.*;

public class SingleNumber {
    /**
     * 异或操作，0^1=1;1^1=0;
     */
    public int singleNumber01(int[] nums){
        int index = 0;
        for (int num : nums) {
            index = index ^ num;
        }
        return index;
    }

    /**
     * 利用 Set 集合不可重复特点，插入失败，则把之成功的删掉
     */
    public int singleNumber02(int[] nums){
        Set set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){
                set.remove(nums[i]);
            }
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            return (int)iterator.next();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums ={1,1,2,4,3,3,2,5};
        System.out.println(new SingleNumber().singleNumber02(nums));

    }
}
