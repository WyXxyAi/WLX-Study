package Algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = 0;
        if ((nums1.length+nums2.length)/2==0){
            index = (nums1.length+nums2.length)/2;
        }else {
            index = (nums1.length+nums2.length)/2+1;
        }
        int i=0,j=0;
        /*while(){
            if (nums1[i]>nums2[j]){
                j++;
            }
        }*/
        return 2.0;
    }
}
