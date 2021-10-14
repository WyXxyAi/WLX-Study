package ThreadStudy;

public class ThreadTest extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread: "+i);
        }
    }
}
class ThreadMain{
    public static void main(String[] args){
        ThreadTest t = new ThreadTest();
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main: "+i);
        }
    }
}
