package Algorithm;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class FindJudge {
    /**
     * 997. 找到小镇的法官
     * 思路 : 出入度统计 ; 统计相信了多少人作为出度 、被多少人相信入度。
     *       如果出度为 0 ;入读为 n-1 ;则此人就是法官。
     */
    public static int findJudge(int n, int[][] trust) {
        int[] tru = new int[n+1];//相信多少人 出度
        int[] beTru = new int[n+1];//被多少人相信 入读
        for (int i = 0; i < trust.length; i++) {
            tru[trust[i][0]]+=1;
            beTru[trust[i][1]]+=1;
        }
        for (int i = 1; i < n + 1; i++) {
            if (tru[i]==0&&beTru[i]==(n-1))return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1,3},{2,3},{3,1}};
        System.out.println(findJudge(n,trust));
    }
}
