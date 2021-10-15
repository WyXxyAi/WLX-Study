package Thread02Study;

public class JoinTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName()+" 是vip客户 先走 "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new JoinTest(),"小谢");
        thread.start();
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if (i==10){
                thread.join();
            }
        }
    }
}
