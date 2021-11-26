package Algorithm.Questions;

import java.util.*;

public class FirstUniqChar {
    /**
     * 统计每个元素出现次数，然后判断如果出现次数为 1 则返回下标。
     */
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 双指针 : 如果前后指针下标一样，则代表元素唯一。
     */
    public static int firstUniqChar1(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))){
                return s.indexOf(s.charAt(i));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "aadadaad";
        System.out.println(firstUniqChar1(s));
    }
}
