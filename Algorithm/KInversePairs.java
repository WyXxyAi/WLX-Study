package Algorithm;

public class KInversePairs {
    public int kInversePairs(int n,int k){
        int[] nums = new int[n-1];
        for (int i = 1; i <= n; i++) {
            nums[i]=i;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        return 0;
    }

    public static void main(String[] args) {
        KInversePairs k = new KInversePairs();
        int res = k.kInversePairs(3,1);
        System.out.println(res);
    }
}
