package Algorithm.Questions;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==1)return 1;
        String res = "";
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            int index = temp.indexOf(String.valueOf(s.charAt(i)));
            if (index!=-1){
                if (temp.length()>res.length()){
                    res = String.valueOf(temp);
                }
                temp=temp.delete(0,index+1);
                temp.append(s.charAt(i));
            }else {
                temp.append(s.charAt(i));
            }
        }
        if (temp.length()>res.length()){
            res = String.valueOf(temp);
        }
        return res.length();
    }

    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
        /*StringBuffer s = new StringBuffer();
        s.append("01234567");
        System.out.println(s.delete(0,2));*/
    }
}
