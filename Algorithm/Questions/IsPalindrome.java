package Algorithm.Questions;

public class IsPalindrome {
    /**
     * 判断回文字符串
     */
    public static boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        for (int i = 0; i < sb.length()/2; i++) {
            if (sb.charAt(i)!=sb.charAt(sb.length()-i-1))return false;
        }
        return true;
    }

    /**
     * 判断回文数
     */
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        int x = 123321;
        System.out.println(isPalindrome(x));
    }
}
