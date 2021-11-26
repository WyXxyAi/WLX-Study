package Algorithm.Questions;

import java.util.*;

public class BuddyStrings {
    public static boolean buddyStrings(String s, String goal) {
        int slen = s.length(),glen = goal.length();
        List<Integer> list = new ArrayList();
        if (slen>1&&slen==glen){
            for (int i = 0; i < slen; i++) {
                if (s.charAt(i)!=goal.charAt(i)){
                    list.add(i);
                }
            }
            if (list.size()==0){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                for (int i = 1; i < chars.length; i++) {
                    if (chars[i]==chars[i-1])return true;
                }
            }
            if (list.size()==2&&s.charAt(list.get(0))==goal.charAt(list.get(1))&&s.charAt(list.get(1))==goal.charAt(list.get(0))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaa";
        String goal = "aba";
        System.out.println(buddyStrings(s,goal));
    }
}
