package Algorithm.KnuthShuffle;

import java.util.Arrays;
import java.util.Random;

/**
 * 洗牌算法
 */
public class Shuffle {
    private int[] nums;

    public Shuffle(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] res = nums.clone();
        for (int i = res.length-1; i >= 0; i--) {
            int a = new Random().nextInt(i+1);
            int temp = res[i];
            res[i]=res[a];
            res[a]=temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Shuffle obj = new Shuffle(nums);
        for (int i = 0; i < 10; i++) {
            int[] res = obj.shuffle();
            System.out.println(Arrays.toString(res));
        }
    }
}
