package Algorithm.Sort;

import java.util.Arrays;

public class MySortRe {
    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    //选择
    public static void searchSort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[i]>nums[j]){
                    swap(nums,i,j);
                }
            }
        }
    }
    //冒泡
    public static void bubbleSort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }
    //插入
    public static void insertSort(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[j]<nums[i]){
                    swap(nums,j,i);
                }
            }
        }
    }
    //希尔
    public static void shellSort(int[] nums){
        int len = nums.length;
        for (int gap = len/2; gap>0 ; gap/=2) {//缩小增量
            for (int i = gap; i < len; i++) {
                for (int j = i; j-gap >= 0; j-=gap) {
                    if (nums[j]<nums[j-gap]){
                        swap(nums,j-gap,j);
                    }
                }
            }

        }
    }
    //归并
    public static void mergerSort(int[] nums){
        int len = nums.length;
        mer_group(nums,0,len-1);
    }
    public static void mer_group(int[] nums,int begin,int end){
        if (begin<end) {
            int mid = (begin + end) / 2;
            mer_group(nums, begin, mid);
            mer_group(nums, mid + 1, end);
            mer_sort(nums, begin, mid, end);
        }
    }
    public static void mer_sort(int[] nums,int begin,int mid,int end){
        int[] temp = new int[nums.length];
        int l = begin,r = mid+1,k = 0;
        while (l<=mid&&r<=end){
            temp[k++]=nums[l]<nums[r]?nums[l++]:nums[r++];
        }
        while (l<=mid){
            temp[k++]=nums[l++];
        }
        while (r<=end){
            temp[k++]=nums[r++];
        }
        k=0;
        while (begin<=end){
            nums[begin++]=temp[k++];
        }
    }
    //快速
    public static void quickSortInit(int[] nums){
        int len = nums.length;
        quickSort(nums,0,len-1);
    }
    public static void quickSort(int[] nums,int start,int end){
        if (start<end) {
            int point = nums[start];
            int left = start + 1;
            int right = end;
            while (left < right) {
                while (nums[right] > point && left != right) {
                    right--;
                }
                while (nums[left] < point && left != right) {
                    left++;
                }
                if (left < right) {
                    swap(nums, left, right);
                }
                if (left == right) {
                    swap(nums, left, start);
                }
            }
            quickSort(nums, start, left - 1);
            quickSort(nums, left + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {9,5,1,8,2,6,3,4,7};
        quickSortInit(nums);
        System.out.println(Arrays.toString(nums));
    }
}
