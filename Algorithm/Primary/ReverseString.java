package Algorithm.Primary;

import java.util.Arrays;

public class ReverseString {
    public static void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len/2; i++) {
            char temp = s[i];
            s[i]=s[len-i-1];
            s[len-i-1]=temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
