package Algorithm.Questions;

public class MaxArea {
    /**
     * 盛最多水的容器
     * 暴力枚举 O(n^2);大量数据就崩了
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        if (len<2)return 0;
        int res = 0;
        for (int i = len-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                res = Math.min(height[i],height[j])*(i-j)<res?res:Math.min(height[i],height[j])*(i-j);
            }
        }
        return res;
    }

    /**
     * 盛最多水的容器
     * 双向判断 O(n)
     */
    public static int maxArea1(int[] height) {
        int len = height.length-1;
        int l=0,r=height.length-1,res=0;
        while (l<r){
            if (height[l]<=height[r]){
                res = res<height[l]*len?height[l]*len:res;
                l++;
            }else {
                res = res<height[r]*len?height[r]*len:res;
                r--;
            }
            len--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
