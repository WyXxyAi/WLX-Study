package Algorithm.Questions;

public class Convert {
    public static String convert(String s, int numRows) {
        if (s.length()<=numRows||numRows==1){return s;}
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            boolean parity = true;int temp=i;//偶t奇f
            while (temp<s.length()){
                /*if (parity){
                    sb.append(chars[temp]);
                    if (2*(numRows-i-1)==0){
                        temp+=2*(numRows-1);
                    }else {
                        temp+=2*(numRows-i-1);
                    }
                    parity=!parity;
                }else {
                    sb.append(chars[temp]);
                    if ((2*(numRows-1))-(2*(numRows-i-1))==0){
                        temp+=2*(numRows-i-1);
                    }else {
                        temp+=(2*(numRows-1))-(2*(numRows-i-1));
                    }
                    parity=!parity;
                }*/
                //跟上面注释掉的功能一样
                sb.append(s.charAt(temp));
                temp+=parity?2*(numRows-i-1)==0?2*(numRows-1):2*(numRows-i-1):(2*(numRows-1))-(2*(numRows-i-1))==0?2*(numRows-i-1):(2*(numRows-1))-(2*(numRows-i-1));
                parity=!parity;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "AB";
        System.out.println(convert(s,1));
    }
}
