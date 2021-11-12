package Algorithm;

import java.util.Arrays;

public class MySort {
    /**
     * 选择排序  平均复杂度O(n^2)
     * 寻找最小值索引，交换到前面
     */
    public static void selection(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if (nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            int temp = nums[i];
            nums[i]=nums[minIndex];
            nums[minIndex]=temp;
        }
    }
    /**
     * 冒泡排序  平均复杂度O(n^2)
     * 两两比较小就交换
     */
    public static void bubble(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if (nums[j]>nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }
    /**
     * 插入排序  平均复杂度O(n^2)
     * 跟前面的比较 比前面小就交换
     */
    public static void insertion(int[] nums){
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j >0; j--) {
                if (nums[j]<nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }
    /**
     * shell排序,希尔排序，缩小增量排序 平均复杂度O(n^1.3)
     * 插入排序进化版本
     */
    public static void shell(int[] nums){
        int len = nums.length;
        for (int gap = len/2; gap >0; gap=gap/2) {//确定步长，不停缩小，直到＝1
            for (int i = gap; i <len; i++) {//确定比较初始位置
                for (int j = i; j-gap>=0; j=j-gap) {//等步长比较
                    if(nums[j]<nums[j-gap]){
                        int temp = nums[j-gap];
                        nums[j-gap]=nums[j];
                        nums[j]=temp;
                    }
                }
            }
        }
    }

    /**
     * 归并排序  递归分组  合并排序(拆成最小，再排序) 平均复杂度O(nlog2n)
     * 利用完全二叉搜索树，Arrays.sort()是归并排序的优化  (元素>286)
     * 先以二叉形式分组 (分为两组，左组，右组)
     * 左组元素小于右组元素 左组元素放入临时数组 左组游标+1;右组同理
     * 左、右组剩余加入临时数组 把临时数组copy到原数组
     */
    //归并排序入口
    public static void merge_group(int[] nums){
        if (nums.length<1){
            System.out.println("error:length<1");
            return;
        }
        int[] temp = new int[nums.length];
        group(nums,temp,0,nums.length-1);//这里传入的是下标
    }
    //递归分组
    public static void group(int[] nums,int[] temp,int left,int right){
        if (left<right){
            //确定分割点，中点
            int mid = (left+right)/2;
            //递归调用，分割左半
            group(nums,temp,left,mid);
            //递归调用，分割右半
            group(nums,temp,mid+1,right);
            //递归，合并
            merge(nums,temp,left,mid,right);
        }
    }
    //合并排序
    public static void merge(int[] nums,int[] temp,int left,int mid,int right){
        //确定左边第一个元素
        int l_index = left;
        //确定右边第一个元素
        int r_index = mid+1;
        //临时数组(temp)游标
        int k = 0;
        //如果左数组第一位小于右数组第一位，则把左数组第一位放入临时数组，并且左数组游标右移;右数组同理
        while (l_index<=mid&&r_index<=right){
            if (nums[l_index]<=nums[r_index]){
                temp[k++]=nums[l_index++];
            }else {
                temp[k++]=nums[r_index++];
            }
        }
        //左数组剩余元素依次加入temp
        while (l_index<=mid){
            temp[k++]=nums[l_index++];
        }
        //右数组剩余元素依次加入temp
        while (r_index<=right){
            temp[k++]=nums[r_index++];
        }
        //把临时数组copy回原数组
        k=0;//重置temp游标
        while (left<=right){
            nums[left++]=temp[k++];
        }
    }

    /**
     * 快速排序 找基准数，小的放基准数左边，大的放基准数右边，双指针
     * Arrays.sort()是快速排序的优化  (47<元素<286)
     * 左边继续找基准数，右边同理
     * 平均复杂度O(nlog2n)
     */
    public static void quick(int[] nums,int left,int right){
        if (left<right) {
            int point = nums[left];
            int l = left + 1, r = right;
            while (l < r) {
                while (nums[r] > point && l != r) {
                    r--;
                }
                while (nums[l] < point && l != r) {
                    l++;
                }
                if (l < r) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                }
            }
            if (l == r) {
                nums[left] = nums[l];
                nums[l] = point;
            }
            quick(nums, 0, l-1);
            quick(nums, l + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] nums ={9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        quick(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
