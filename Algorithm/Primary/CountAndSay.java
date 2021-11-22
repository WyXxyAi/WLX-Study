package Algorithm.Primary;

public class CountAndSay {
    /**
     * 递归+双指针
     */
    public static String countAndSay(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;
        String res = "";int count = 0;
        for (int i = 0; i < chars.length; i++) {
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countAndSay(n));
    }
}
