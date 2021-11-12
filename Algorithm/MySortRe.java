package Algorithm;

import java.util.Arrays;

public class MySortRe {
    //选择
    public static void reSelection(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i; j < len; j++) {
                minIndex = nums[j]<nums[minIndex]?j:minIndex;
            }
            int temp = nums[i];
            nums[i]=nums[minIndex];
            nums[minIndex]=temp;
        }
    }
    //冒泡
    public static void reBubble(int[] nums){
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
    //插入
    public static void reInsert(int[] nums){
        int len =nums.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if (nums[j]<nums[j-1]){
                    int temp = nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
    }
    //希尔;缩小增量
    public static void reShell(int[] nums){
        int len = nums.length;
        for (int gap = len/2; gap > 0; gap=gap/2) {
            for (int i = gap; i < len; i++) {
                for (int j = i; j-gap>=0; j=j-gap) {
                    if (nums[j]<nums[j-gap]){
                        int temp = nums[j-gap];
                        nums[j-gap]=nums[j];
                        nums[j]=temp;
                    }
                }
            }
        }
    }
    //归并排序
    public static void reMergeInit(int[] nums){
        int len = nums.length;
        int[] temp = new int[len];
        reMergeGroup(nums,temp,0,len-1);
    }
    public static void reMergeGroup(int[] nums,int[] temp,int left,int right){
        if (left<right){
            int mid = (left+right)/2;
            reMergeGroup(nums,temp,left,mid);
            reMergeGroup(nums,temp,mid+1,right);
            reMergeSort(nums,temp,left,mid,right);
        }
    }
    public static void reMergeSort(int[] nums,int[] temp,int left,int mid,int right){
        int lIndex = left;
        int rIndex = mid+1;
        int k = 0;
        while (lIndex<=mid&&rIndex<=right){
            temp[k++]=nums[lIndex]<nums[rIndex]?nums[lIndex++]:nums[rIndex++];
        }
        while (lIndex<=mid){
            temp[k++]=nums[lIndex++];
        }
        while (rIndex<=right){
            temp[k++]=nums[rIndex++];
        }
        k=0;
        while (left<=right){
            nums[left++]=temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {9,5,1,8,2,6,3,4,7};
        reMergeInit(nums);
        System.out.println(Arrays.toString(nums));
    }
}
