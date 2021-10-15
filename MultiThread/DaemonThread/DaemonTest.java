package MultiThread.DaemonThread;

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("开心快乐每一天");
        }
        System.out.println("****不开心****");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("God永远保护你");
        }
    }
}

public class DaemonTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new You());
        Thread thread1 = new Thread(new God());
        thread1.setDaemon(true);
        thread.start();
        thread1.start();
    }
}
