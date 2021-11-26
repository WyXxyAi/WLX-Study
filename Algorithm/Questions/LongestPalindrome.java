package Algorithm.Questions;

import java.util.Arrays;

public class LongestPalindrome {
    /**
     * 马拉算法，判断最长回文字符串
     */
    public static String longestPalindrome(String s) {
        if (s.length()<2)return s;
        String ss = "#";
        for (int i = 0; i < s.length(); i++) {
            ss+=s.charAt(i)+"#";
        }
        int[] p = new int[ss.length()];
        int maxMid=0,maxLeft=0,mi=0;
        for (int i = 1; i < ss.length()-1; i++) {
            if (i<maxLeft){
                mi = maxMid-(i-maxMid);
                p[i]=Math.min(p[mi],maxLeft-i);
            }else {
                p[i]=1;
            }
            while (ss.charAt(i-p[i])==ss.charAt(i+p[i])){
                p[i]++;
                if (i-p[i]<0||i+p[i]>ss.length()-1){
                    break;
                }
            }
            if (i+p[i]>maxLeft){
                maxLeft=i+p[i]-1;
                maxMid=i;
            }
        }
        int resLen = 0,index = 0;
        for (int i = 0; i < p.length; i++) {
            if (resLen<p[i]){
                resLen = p[i];
                index = i;
            }
        }
        int start = index/2-(resLen-1)/2;
        int end = start + resLen-1;
        return s.substring(start,end);
    }

    public static void main(String[] args) {
        String s = "babd";
        System.out.println(longestPalindrome(s));
    }
}
