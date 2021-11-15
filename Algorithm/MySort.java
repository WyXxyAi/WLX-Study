package Algorithm;

import java.util.Arrays;

public class MySort {
    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
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
                if (l == r) {
                    nums[left] = nums[l];
                    nums[l] = point;
                }
            }

            quick(nums, 0, l-1);
            quick(nums, l + 1, right);
        }
    }

    /**
     * 双轴快排 有有两个基准数
     * 拆成3组,小于point1,大于point1小于point2,大于point2
     * 三组继续递归排
     */
    public static void quickBiaxInit(int[] nums){
        quickBiax(nums,0,nums.length-1);
    }
    public static void quickBiax(int[] nums,int left,int right){
        if (left<right) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
            }
            int point1 = nums[left];//左基准数
            int point2 = nums[right];//右基准数
            /*i左边第一个元素，也是 < point1 组的游标
              j右边最后一个元素，也是 point2 > 组的游标,也是未确定组的右游标
              k为未确定组的游标，当k = j时，未确定组全部排完，则一轮结束*/
            int i = left, j = right, k = i + 1;
            loop:{
                while (k < j) {
                    if (nums[k] < point1) {//小于point1，跟左边元素替换，++i是为了防止point1发生替换
                        swap(nums, k++, ++i);
                    } else if (nums[k] >= point1 && nums[k] < point2) {//在point1和point2之间，就继续走
                        k++;
                    } else {//大于point2，不可直接与右边替换，因为不知道右边元素是多大，所以又三种情况
                        while (nums[j] >= point2) {//如果右边元素大于point2就继续走
                            if (k==j){//k和j相等了，就直接结束，跳出外层循环
                                break loop;
                            }
                            j--;
                        }
                        if (nums[j] > point1 && nums[j] < point2) {//右边元素在point1和point2之间，就继续走
                            swap(nums, k++, j);
                        } else {//小于point1，先跟++1替换，再跟k替换
                            swap(nums, ++i, j);
                            swap(nums, k, j);
                        }
                    }
                }
            }
            if (k == j) {
                swap(nums, left, i);
                swap(nums, right, j);
                quickBiax(nums, left, i - 1);
                quickBiax(nums, i + 1, j - 1);
                quickBiax(nums, j + 1, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums ={4,9,5,1,8,2,0,3,6,7};
        quickBiaxInit(nums);
        System.out.println(Arrays.toString(nums));
    }
}
