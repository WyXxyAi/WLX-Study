package Algorithm.Questions;

public class MaxStr {
    //1.
    public int maxStr01(String str){
        int res = 0;
        if (str != null && str.length() >1) {
            char[] ct = str.toCharArray();
            int len = str.length();String s = "";
            int startIndex=0,endIndex=0;
            for (int i = 0; i < len; i++) {
                s=str.substring(startIndex,i);
                if (s.indexOf(ct[endIndex])!=-1){
                    res= s.length();
                    s = "";
                    startIndex++;
                    i = startIndex+1;
                }else {
                    endIndex++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxStr maxStr = new MaxStr();
        int res = maxStr.maxStr01("abcdbaefga");
        System.out.println(res);
    }
}
