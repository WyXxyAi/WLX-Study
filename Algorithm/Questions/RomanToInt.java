package Algorithm.Questions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    /**
     * 罗马转数字
     */
    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap();
        map.put('I',1);map.put('V',5);map.put('X',10);
        map.put('L',50);map.put('C',100);map.put('D',500);
        map.put('M',1000);
        int res = 0;
        if (s.length()<2)return map.get(s.charAt(0));
        for (int i = 0; i < s.length()-1; i++) {
            res += map.get(s.charAt(i))<map.get(s.charAt(i+1))?map.get(s.charAt(i+1))-map.get(s.charAt(i++)):map.get(s.charAt(i));
            if (i==s.length()-2){
                res += map.get(s.charAt(i))<map.get(s.charAt(i+1))?0:map.get(s.charAt(i+1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
        int[] a = {1000,100,1000,10,100,1,5};
    }
}
