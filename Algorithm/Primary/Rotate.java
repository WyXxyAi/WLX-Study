package Algorithm.Primary;

import java.util.Arrays;

public class Rotate {
    /**
     * 旋转数组
     */
    public static void rotate(int[] nums,int k) {
        int len = nums.length;
        k = k%len;
        int[] head = Arrays.copyOf(nums,len-k);
        int[] foot = Arrays.copyOfRange(nums,len-k,len);
        System.arraycopy(foot,0,nums,0,foot.length);
        System.arraycopy(head,0,nums,foot.length,head.length);
        System.out.println(Arrays.toString(nums));
    }
    /**
     * 旋转矩阵
     */
    public static void rotate1(int[][] matrix) {
        int len = matrix.length-1;
        for(int i = 0;i<matrix.length/2+1 ; i++){
            for(int j = i;j<len-i;j++){
                int LT=matrix[i][j];
                matrix[i][j]=matrix[len-j][i];
                matrix[len-j][i]=matrix[len-i][len-j];
                matrix[len-i][len-j]=matrix[j][len-i];
                matrix[j][len-i]=LT;
            }
        }
    }

    public static void main(String[] args) {
        //int[] nums = {4,7,6,2};
        //rotate(nums,2);
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate1(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        //System.out.println(matrix.length/2);
    }

}
