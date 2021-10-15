package Thread02Study;

public class StopTest implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            if (flag){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }else {
                System.out.println(Thread.currentThread().getName()+" Stop");
            }
        }
    }

    public void reverseFlag() {
        this.flag = !flag;
    }

    public static void main(String[] args) {
        StopTest stopTest = new StopTest();
        new Thread(stopTest,"这就是rap").start();
        for (int i = 0; i < 30; i++) {
            if (i==20){
                stopTest.reverseFlag();
            }
        }
    }
}
