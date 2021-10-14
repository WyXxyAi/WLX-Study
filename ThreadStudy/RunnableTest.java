package ThreadStudy;

public class RunnableTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runnale: "+i);
        }
    }
}
class RunnableMain{
    public static void main(String[] args) {
        RunnableTest t = new RunnableTest();
        Thread thread = new Thread(t);
        thread.start();
        for (int i = 0; i < 10 ; i++) {
            System.out.println("Main: "+i);
        }
    }
}
