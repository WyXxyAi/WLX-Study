package Play;

import java.util.Arrays;
import java.util.Scanner;

public class ZhiNeng {
    public static void main(String[] args) {
        Scanner question = new Scanner(System.in);
        System.out.println("���������⣬�����ԡ��𡱻��ߡ�������β������ʶ�𲻳����⡣");
        while (true){
            String res = question.next();
            if (res.contains("��")||res.contains("��")){
                res = res.replace("��","��");
                res = res.replace("��","");
                res = res.replace("��","!");
                System.out.println(res);
            }else {
                System.out.println("����˵ʲô������������");
            }
        }
    }
}
