package Thread02Study;

public class ThreadStateTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("***********");
            }
        });

        while(thread.getState()!=Thread.State.TERMINATED){
            if (!thread.isAlive()){
                System.out.println(thread.getState());//NEW
                thread.start();}
            System.out.println(thread.getState());//RUNNABLE-->TIMED_WAITING
            Thread.sleep(333);
        }
        if (thread.getState()==Thread.State.TERMINATED){
            System.out.println(thread.getState());//TERMINATED
        }

    }
}
