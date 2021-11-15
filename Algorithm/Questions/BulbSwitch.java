package Algorithm.Questions;

import java.util.HashMap;
import java.util.Map;

public class BulbSwitch {
    /**
     * 题目:初始时有n 个灯泡处于关闭状态。
     * 第一轮，你将会打开所有灯泡。
     * 第二轮，你将会每两个灯泡关闭一个。
     * 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
     * 找出并返回 n轮后有多少个亮着的灯泡。
     *
     * 思路:灯泡只有在约数轮才会切换状态
     *      根据题意
     *          如果有偶数个约数状态会切为初始状态 (如：6=1*6；6=2*3有4个约数则其最后状态为 灭 )
     *          如果有奇数个约数状态会切为相反状态 (如：4=1*4；4=2*2有3个约数则其最后状态为 亮 )
     *      注：约数都是成对出现的，只有出现约数为某个数得平放，才可能有奇数个约数。
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
    public static void main(String[] args) {
        BulbSwitch bulbSwitch = new BulbSwitch();
        System.out.println(bulbSwitch.bulbSwitch(5));
    }
}
