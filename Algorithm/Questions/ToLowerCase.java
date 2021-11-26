package Algorithm.Questions;

public class ToLowerCase {
    public static String toLowerCase(String s) {
        String res  ="";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                res += (char)(s.charAt(i)+('a'-'A'));
            }else {
                res +=s.charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ABC_cba";
        System.out.println(toLowerCase(s));
    }
}
