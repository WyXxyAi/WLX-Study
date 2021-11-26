import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.*;

public class Test {
    /**
     * ����value��ȡkey��ֻ�ܻ�ȡ���һ������������key��
     */
    public <E,T>E getKey(Map<E,T> map,T value){
        for (E e : map.keySet()) {
            if (map.get(e)==value){
                return e;
            }
        }
        return null;
    }

    public static void sort(int []arr){
        int []temp = new int[arr.length];//������ǰ���Ƚ���һ�����ȵ���ԭ���鳤�ȵ���ʱ���飬����ݹ���Ƶ�����ٿռ�
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//��߹鲢����ʹ��������������
            sort(arr,mid+1,right,temp);//�ұ߹鲢����ʹ��������������
            merge(arr,left,mid,right,temp);//����������������ϲ�����
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//������ָ��
        int j = mid+1;//������ָ��
        int t = 0;//��ʱ����ָ��
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//�����ʣ��Ԫ������temp��
            temp[t++] = arr[i++];
        }
        while(j<=right){//��������ʣ��Ԫ������temp��
            temp[t++] = arr[j++];
        }
        t = 0;
        //��temp�е�Ԫ��ȫ��������ԭ������
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
    public boolean TestBoolean(String s){
        return false;
    }
    public static void main(String[] args) {
    }
}
