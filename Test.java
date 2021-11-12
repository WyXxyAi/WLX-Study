import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.*;

public class Test {
    /**
     * ����value��ȡkey��ֻ�ܻ�ȡ���һ������������key��
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
    public static void main(String[] args) {
        int []arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
