package Thread02Study;

/**
 * @description : 模拟青壮年礼让老弱病残孕
 */
public class YiledTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            if (i%10==0&&Thread.currentThread().getName().equals("青壮年")){
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

    public static void main(String[] args) {
        Thread thread01 = new Thread(new YiledTest(),"青壮年");
        Thread thread02 = new Thread(new YiledTest(),"老弱病残");
        thread01.start();thread02.start();
    }
}
