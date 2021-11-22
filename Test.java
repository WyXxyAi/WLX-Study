import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.*;

public class Test {
    /**
     * 根据value获取key（只能获取最后一个符合条件的key）
     */
    public Object getKey(Map map,Object value){
        Object res = null;
        for (Object o : map.keySet()) {
            if (map.get(o)==value){
                res = o;
            }
        }
        return res;
    }

    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
    public static int MaxContinueArraySum(int a[]) {
        int n = a.length;
        int max = a[0];
        int sum = a[0];
        for(int i=1;i<n;i++){
            sum = Math.max(sum+a[i], a[i]);
            if(sum>=max){
                max = sum;
            }
        }
        return max;
    }
    public static boolean TestBoolean(String s) {
        String t = new String(s);
        return t==s;
    }
    public static void main(String[] args) {
        final byte x = 1;
        final byte y = x+x;
        System.out.println(y);
        int temp = 0;
        temp = 6-6==0?2-2==0?1:2:4;
        System.out.println(temp);
    }
}
