package Algorithm.Primary;

public class IsPalindrome {
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

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
