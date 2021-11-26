package Algorithm.Questions;

public class MyAtoi {
    public static int sout(String temp){
        if (temp.equals(""))return 0;
        if (Long.parseLong(temp)<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else if (Long.parseLong(temp)<Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }else {
            return (int)Long.parseLong(temp);
        }
    }

    public static int myAtoi(String s) {
        String temp="";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))||s.charAt(i)=='-'){
                temp+=s.charAt(i);
            }else if (s.charAt(i)==' '||s.charAt(i)=='+'){

            }else if (!temp.equals("")){
                return sout(temp);
            }else {
                return 0;
            }
        }
        return sout(temp);
    }

    public static void main(String[] args) {
        String s = " -+123abc";
        System.out.println(myAtoi(s));
    }
}
