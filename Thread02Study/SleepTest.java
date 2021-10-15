package Thread02Study;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @describtion : 模拟计时
 */
public class SleepTest implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            Date date = new Date(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
        }

    }

    public static void main(String[] args) {
        new Thread(new SleepTest()).start();
    }
}
