package Algorithm.Primary;

public class PlusOne {
    /**
     * 反向遍历如果不为9则加一直接返回，如果为9则变成零进下一轮，如果都为9则扩一位
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0; i--) {
            if (digits[i]!=9){
                digits[i]+=1;
                return digits;
            }else {
                digits[i]=0;
            }
        }
        int[] res = new int[digits.length+1];
        res[0]=1;
        return res;
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9,8};
        int[] res = new PlusOne().plusOne(digits);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
