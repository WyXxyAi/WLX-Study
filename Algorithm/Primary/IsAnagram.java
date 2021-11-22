package Algorithm.Primary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    /**
     * 记录两字符串中元素出现次数
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length()==t.length()){
            Map<Character,Integer> maps = new HashMap();
            Map<Character,Integer> mapt = new HashMap();
            for (int i = 0; i < s.length(); i++) {
                maps.put(s.charAt(i),maps.getOrDefault(s.charAt(i),0)+1);
                mapt.put(t.charAt(i),mapt.getOrDefault(t.charAt(i),0)+1);
            }
            for (int i = 0; i < s.length(); i++) {
                if (!maps.get(s.charAt(i)).equals(mapt.get(s.charAt(i)))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 排序之后完全一样
     */
    public static boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        for (int i = 0; i <chars.length; i++) {
            if (chars[i]!=chart[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabbccdda";
        String t = "abcdabcdb";
        System.out.println(isAnagram1(s,t));
    }
}
