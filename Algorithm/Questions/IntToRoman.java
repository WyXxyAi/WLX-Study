package Algorithm.Questions;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
    /**
     * 罗马数字在1~4999之间
     * 思路 : 判断在那两个数之间，然后拼一位减去相应的数，知道为0
     */
    public static String intToRoman(int num) {
        int[] nums = {1,4,5,9,10,40,50,90,100,400,500,900,1000,5000};
        String res = "";
        String[] strs={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        while (num!=0) {
            for (int i = 0; i < nums.length; i++) {
                while (num >= nums[i] && num < nums[i + 1]) {
                    res += strs[i];
                    num -= nums[i];
                }
                if (num == 0) {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int s = 1994;
        System.out.println(intToRoman(s));
    }
}
