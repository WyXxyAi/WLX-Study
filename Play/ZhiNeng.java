package Play;

import java.util.Arrays;
import java.util.Scanner;

public class ZhiNeng {
    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("可以问问题，尽量以“吗”或者”？“结尾，否则识别不出问题。");
        while (true){
            String res = question.next();
            if (res.contains("吗")||res.contains("？")){
                res = res.replace("你","我");
                res = res.replace("吗","");
                res = res.replace("？","!");
                System.out.println(res);
            }else {
                System.out.println("你在说什么，我听不懂！");
            }
        }
    }
}
