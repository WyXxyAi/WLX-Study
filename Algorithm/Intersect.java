package Algorithm;

import java.util.*;

public class Intersect {
    /**
     *  自己写的垃圾，反正能过，摆烂代码
     *  思路 : 用2中元素逐个与1中元素比较，相同就把元素放进临时temps，并删除1中的对应元素，遍历临时temps。
     */
    public int[] intersect01(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        List<Integer> temps = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (list.contains(nums2[i])){
                int index = list.indexOf(nums2[i]);
                list.remove(index);
               temps.add(nums2[i]);
            }
        }
        int[] res = new int[temps.size()];
        for (int i = 0; i < temps.size(); i++) {
            res[i]=temps.get(i);
        }
        return res;
    }

    /**
     * map记录法，key为值，value为个数
     * 如果其中一个很小，另一个很大适合这个
     */
    public int[] intersect02(int[] nums1, int[] nums2) {
        return nums1;
    }

    /**
     * 排序双指针
     */
    public int[] intersect03(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        int i=0,j=0,k=0;
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]<nums2[j]){
                i++;
            }else if (nums1[i]>nums2[j]){
                j++;
            }else {
                res[k]=nums1[i];
                i++;
                j++;
                k++;
            }
        }
        return Arrays.copyOfRange(res,0,k);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5,9,5,8};
        int[] nums2 = {9,4,9,8,4,3,6,8};
        int[] res01 = new Intersect().intersect01(nums1,nums2);
        int[] res02 = new Intersect().intersect02(nums1,nums2);
        int[] res03 = new Intersect().intersect03(nums1,nums2);
        for (int re : res03) {
            System.out.print(re+" ");
        }
    }
}
