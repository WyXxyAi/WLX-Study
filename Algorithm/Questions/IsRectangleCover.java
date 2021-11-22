package Algorithm.Questions;

import java.util.*;

public class IsRectangleCover {
    /**
     * 判断顶点出现次数，放到set数组，奇数次保留，偶数次删除
     * 判断最后set数组是否只有4个元素，并且为完美矩形的四个顶点
     */
    public boolean isRectangleCover(int[][] rectangles) {
        Set parity = new HashSet();
        int sumS = 0;int maxS = 0;int maxLB = 0;int maxRT = 0;
        for (int i = 0; i < rectangles.length; i++) {
            sumS += (rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]);
            //判断顶点出现次数
            int[] points = {rectangles[i][0]*10+rectangles[i][1],
                    rectangles[i][2]*10+rectangles[i][3],
                    rectangles[i][0]*10+rectangles[i][3],
                    rectangles[i][2]*10+rectangles[i][1]};
            for (int j = 0; j < points.length; j++) {
                if (parity.contains(points[j])){
                    parity.remove(points[j]);
                }else {
                    parity.add(points[j]);
                }
            }
        }
        //判断最大面积
        if (parity.size()==4) {
            for (int i = 0; i < parity.toArray().length; i++) {
                if (i == 0) {
                    maxLB = (int) parity.toArray()[0];
                    maxRT = (int) parity.toArray()[0];
                } else {
                    if ((int) parity.toArray()[i] / 10 < maxLB / 10 || (int) parity.toArray()[i] % 10 < maxLB % 10) {
                        maxLB = (int) parity.toArray()[i];
                    }
                    if ((int) parity.toArray()[i] / 10 > maxRT / 10 || (int) parity.toArray()[i] % 10 > maxRT % 10) {
                        maxRT = (int) parity.toArray()[i];
                    }
                }
            }
            maxS = (maxRT / 10 - maxLB / 10) * (maxRT % 10 - maxLB % 10);
            if (maxS==sumS){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] rectangles ={{1,1,2,2},{1,1,2,2},{2,1,3,2}};/*{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};*/
        IsRectangleCover isRectangleCover = new IsRectangleCover();
        boolean res = isRectangleCover.isRectangleCover(rectangles);
        System.out.println(res);
    }
}
